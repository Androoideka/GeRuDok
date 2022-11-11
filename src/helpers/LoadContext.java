package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import exceptions.NoPreviousWorkspaceFoundException;
import exceptions.OpenException;
import exceptions.OptionException;
import workspace.model.MPNode;
import workspace.model.Workspace;

public class LoadContext<T extends MPNode> {
    private Class<T> type;
    private LoadPurpose purpose;
    private File file;
    private LoadFailCause cause;

    public LoadContext(LoadContext<T> context) {
        this.type = context.type;
        this.purpose = context.purpose;
    }

    public LoadContext(Class<T> type, LoadPurpose purpose) {
        this.type = type;
        this.purpose = purpose;
    }

    public Class<T> getType() {
        return type;
    }

    public LoadPurpose getPurpose() {
        return purpose;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public LoadFailCause getCause() {
        return cause;
    }

    public void setCause(Exception exception) {
        if (exception instanceof FileNotFoundException) {
            this.cause = LoadFailCause.FileNotFound;
        } else if (exception instanceof ClassCastException) {
            this.cause = LoadFailCause.WrongClass;
        } else if (exception instanceof ClassNotFoundException) {
            this.cause = LoadFailCause.ClassNotFound;
        } else if (exception instanceof IOException) {
            this.cause = LoadFailCause.IO;
        }
    }

    public OptionException createLoadException() {
        if (purpose == LoadPurpose.PREV && type.equals(Workspace.class)) {
            return NoPreviousWorkspaceFoundException.create(cause);
        } else {
            return OpenException.create(cause, type.getSimpleName());
        }
    }
}
