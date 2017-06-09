package com.example.administrator.live.Bean;

/**
 * Created by Administrator on 2017/6/6.
 */

public class User_Reg {

    /**
     * ret : 0
     * data : {"\u201csession\u201d":"\u201c5559936945f96e05efbbf344\u201d"}
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

        public String getSession() {
            return session;
        }

        public void setSession(String Session) {
            this.session = session;
        }
    }
}
