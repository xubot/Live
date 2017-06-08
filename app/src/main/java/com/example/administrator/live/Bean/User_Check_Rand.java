package com.example.administrator.live.Bean;

/**
 * Created by Administrator on 2017/6/6.
 */

public class User_Check_Rand {

    /**
     * ret : 0
     * data : {"\u201clogin\u201d":true,"\u201csession\u201d":"\u201c5559936945f96e05efbbf344\u201d","\u201cuname\u201d":"\u201c13800000\u201d","\u201calert\u201d":true,"\u201cmessage\u201d":"\u201c你获得赠送100元充值\u201d"}
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
        private boolean login; // FIXME check this code
        private String session; // FIXME check this code
        private String uname; // FIXME check this code
        private boolean alert; // FIXME check this code
        private String message; // FIXME check this code

        public boolean isLogin() {
            return login;
        }

        public void setLogin(boolean login) {
            login = login;
        }

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            session = session;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            uname = uname;
        }

        public boolean isAlert() {
            return alert;
        }

        public void setAlert(boolean alert) {
            alert = alert;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            message = message;
        }
    }
}
