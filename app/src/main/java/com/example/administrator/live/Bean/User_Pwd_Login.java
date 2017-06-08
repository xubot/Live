package com.example.administrator.live.Bean;

/**
 * Created by Administrator on 2017/6/7.
 */

public class User_Pwd_Login {

    /**
     * ret : 0
     * data : {"\u201csession\u201d":"\u201c5559936945f96e05efbbf344\u201d","\u201calert\u201d":false,"\u201cmessage\u201d":"\u201c \u201d"}
     */

    private int ret;
    private DataBean data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String session; // FIXME check this code
        private boolean alert; // FIXME check this code
        private String message; // FIXME check this code

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public boolean isAlert() {
            return alert;
        }

        public void setAlert(boolean alert) {
            this.alert = alert;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
