package com.example.administrator.live.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/28.
 */

public class List_Topic {
    private DataBean data;
    private int ret;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public static class DataBean {

        private String page_index;
        private int total;
        private String page_size;
        private List<TopicBean> topic;



        public String getPage_index() {
            return page_index;
        }

        public void setPage_index(String page_index) {
            this.page_index = page_index;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getPage_size() {
            return page_size;
        }

        public void setPage_size(String page_size) {
            this.page_size = page_size;
        }

        public List<TopicBean> getTopic() {
            return topic;
        }

        public void setTopic(List<TopicBean> topic) {
            this.topic = topic;
        }

        public static class TopicBean {


            private String title2;
            private String title;
            private String image;
            private int type;
            private int length;

            public String getTitle2() {
                return title2;
            }

            public void setTitle2(String title2) {
                this.title2 = title2;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }
        }
    }

    @Override
    public String toString() {
        return "Free_bean{" +
                "data=" + data +
                ", ret=" + ret +
                '}';
    }
}
