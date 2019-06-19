//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //


package com.sales.models;

public class SaveResult {

    public boolean getSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void appendErrorMsg(String msg) {
        this.errorMsg += "\n";
        this.errorMsg += msg;
    }

    private boolean saved;
    private String errorMsg;
}
