package com.example.administrator.live.Bean;

/**
 * Created by Administrator on 2017/5/26.
 */

public class Host {
    private String ret;
    private HostBean data;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public HostBean getHostBean() {
        return data;
    }

    public void setHostBean(HostBean data) {
        this.data = data;
    }

    public class  HostBean{
        private String url_host;

        public String getUrl_host() {
            return url_host;
        }

        public void setUrl_host(String url_host) {
            this.url_host = url_host;
        }
    }
}
