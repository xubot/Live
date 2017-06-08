package com.example.administrator.live.Bean;

/**
 * Created by Administrator on 2017/5/25.
 */

public class First_hand {
    /**
     * ret : 0
     * data : {"\u201capp_id\u201d":"\u201cB406A2EF\u201d","\u201cprivate_key\u201d":"\u201cAEF63FBAEDD31000F25FAD2E4C3C2974\u201d"}
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

        private String app_id;
        private String private_key;

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getPrivate_key() {
            return private_key;
        }

        public void setPrivate_key(String private_key) {
            this.private_key = private_key;
        }
    }
}
