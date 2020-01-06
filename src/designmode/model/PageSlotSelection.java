package designmode.model;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

import document.model.Slot;

public class PageSlotSelection implements Transferable, ClipboardOwner {
	public static DataFlavor slotFlavor;
	private DataFlavor[] supportedFlavors= {slotFlavor};
	public ArrayList<Slot> pageSlots=new ArrayList<>();
	
	public PageSlotSelection(ArrayList<Slot> slots) {
		pageSlots = slots;
		try {
			slotFlavor = new DataFlavor(Class.forName("java.util.ArrayList"), "Slots");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if(flavor.equals(slotFlavor)) {
			return pageSlots;
		}else {
			throw new UnsupportedFlavorException(slotFlavor);
		}
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return supportedFlavors;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return (flavor.equals(slotFlavor));
	}
	
	public ArrayList<Slot> getPageSlots(){
		return pageSlots;
	}
}
