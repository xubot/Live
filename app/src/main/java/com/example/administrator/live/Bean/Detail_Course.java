package com.example.administrator.live.Bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/6/9.
 */

public class Detail_Course {

    /**
     * ret : 0
     * data : {"\u201cobject_id\u201d":"\u201c1000010\u201d","\u201ctitle\u201d":"\u201c\u201d","\u201ctitle2\u201d":"\u201c\u201d","\u201cabstract\u201d":"\u201c\u201d","\u201cspeaker_head\u201d":"\u201c\u201d","\u201cspeaker_audio\u201d":"\u201c\u201d","\u201ccourse_video\u201d":"\u201c\u201d","\u201ctry_length\u201d":180,"\u201cvolume\u201d":10,"\u201ccomment_num\u201d":101,"\u201cexam_score\u201d":-1,"\u201cservice_tel\u201d":"\u201c110\u201d"}
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
        private String object_id; // FIXME check this code
        private String title; // FIXME check this code
        private String title2; // FIXME check this code
        @SerializedName("abstract")
        private String abstract2; // FIXME check this code
        private String speaker_head; // FIXME check this code
        private String speaker_audio; // FIXME check this code
        private String course_video;// FIXME check this code
        private int try_length; // FIXME check this code
        private int volume; // FIXME check this code
        private int comment_num; // FIXME check this code
        private int exam_score; // FIXME check this code
        private String Service_tel; // FIXME check this code

        public String getObject_id() {
            return object_id;
        }

        public void setObject_id(String object_id) {
            this.object_id = object_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle2() {
            return title2;
        }

        public void setTitle2(String title2) {
            this.title2 = title2;
        }

        public String get_$Abstract23() {
            return abstract2;
        }

        public void setAbstract(String abstract2) {
            this.abstract2 = abstract2;
        }

        public String getSpeaker_head() {
            return speaker_head;
        }

        public void setSpeaker_head3(String speaker_head) {
            this.speaker_head = speaker_head;
        }

        public String getAbstract2() {
            return abstract2;
        }

        public void setAbstract2(String abstract2) {
            this.abstract2 = abstract2;
        }

        public void setSpeaker_head(String speaker_head) {
            this.speaker_head = speaker_head;
        }

        public String getSpeaker_audio() {
            return speaker_audio;
        }

        public void setSpeaker_audio(String speaker_audio) {
            this.speaker_audio = speaker_audio;
        }

        public String getCourse_video() {
            return course_video;
        }

        public void setCourse_video(String course_video) {
            this.course_video = course_video;
        }

        public int getTry_length() {
            return try_length;
        }

        public void setTry_length(int try_length) {
            this.try_length = try_length;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public int getComment_num() {
            return comment_num;
        }

        public void setComment_num(int comment_num) {
            this.comment_num = comment_num;
        }

        public int getExam_score() {
            return exam_score;
        }

        public void setExam_score(int exam_score) {
            this.exam_score = exam_score;
        }

        public String getService_tel() {
            return Service_tel;
        }

        public void setService_tel(String service_tel) {
            Service_tel = service_tel;
        }
    }
}
