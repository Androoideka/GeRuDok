package workspace.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import exceptions.ExceptionHandler;
import exceptions.SaveException;
import helpers.DocumentFileFIlter;
import helpers.LoadContext;
import helpers.LoadFailCause;
import view.MainFrame;

public class Repository {
	public static File prevWS = new File("prevWS.loc");
	private static Repository instance = null;

	private Repository() {

	}

	private void retrySave(MPNode mpNode, File file, LoadFailCause cause) {
		int value = ExceptionHandler.createOptionDialog(SaveException.create(cause));
		if (value == JOptionPane.YES_OPTION) {
			saveAs(mpNode);
		} else if (value == JOptionPane.NO_OPTION) {
			save(mpNode, file);
		}
	}

	private LoadFailCause saveToFile(MPNode mpNode, File file) {
		try {
			ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
			ous.writeObject(mpNode);
			ous.close();
			return null;
		} catch (FileNotFoundException e) {
			return LoadFailCause.FileNotFound;
		} catch (IOException e) {
			return LoadFailCause.IO;
		}
	}

	private void save(MPNode mpNode, File file) {
		LoadFailCause cause = saveToFile(mpNode, file);
		if (cause == null) {
			mpNode.setFile(file.toString());
			mpNode.setChanged(false);
			if (mpNode instanceof Workspace) {
				saveToFile(mpNode, prevWS);
			}
		} else {
			retrySave(mpNode, file, cause);
		}
	}

	public void save(MPNode mpNode) {
		String fileName = mpNode.getFile();
		if (fileName == null) {
			saveAs(mpNode);
		} else {
			File file = new File(fileName);
			save(mpNode, file);
		}
	}

	public void saveAs(MPNode mpNode) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new DocumentFileFIlter());
		File file;
		if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
			file = jfc.getSelectedFile();
			if (!file.getAbsolutePath().endsWith(".mp")) {
				file = new File(file + ".mp");
			}
			save(mpNode, file);
		} else {
			return;
		}
	}

	private <T extends MPNode> T retryOpen(LoadContext<T> context) {
		int value = ExceptionHandler.createOptionDialog(context.createLoadException());
		if (value == JOptionPane.YES_OPTION) {
			return Repository.getInstance().open(new LoadContext<T>(context));
		}
		return null;
	}

	public <T extends MPNode> T open(LoadContext<T> context) {
		if (context.getFile() == null) {
			JFileChooser jfc = new JFileChooser();
			jfc.setFileFilter(new DocumentFileFIlter());
			if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
				context.setFile(jfc.getSelectedFile());
			}
		}

		T mpNode = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(context.getFile()));
			try {
				mpNode = context.getType().cast(ois.readObject());
			} catch (ClassCastException e) {
				context.setCause(e);
				retryOpen(context);
			} catch (ClassNotFoundException e) {
				context.setCause(e);
				retryOpen(context);
			}
			ois.close();
		} catch (FileNotFoundException e) {
			context.setCause(e);
			retryOpen(context);
		} catch (IOException e) {
			context.setCause(e);
			retryOpen(context);
		}
		return mpNode;
	}

	public static Repository getInstance() {
		if (instance == null) {
			instance = new Repository();
		}
		return instance;
	}
}
