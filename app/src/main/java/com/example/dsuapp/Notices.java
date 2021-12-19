package com.example.dsuapp;

public class Notices {
    String noticeSubject, noticeBody, noticeDate;

    public Notices() {
    }

    public Notices(String noticeSubject, String noticeBody, String noticeDate) {
        this.noticeSubject = noticeSubject;
        this.noticeBody = noticeBody;
        this.noticeDate = noticeDate;
    }

    public void setNoticeSubject(String noticeSubject) {
        this.noticeSubject = noticeSubject;
    }

    public void setNoticeBody(String noticeBody) {
        this.noticeBody = noticeBody;
    }

    public void setNoticeDate(String noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getNoticeSubject() {
        return noticeSubject;
    }

    public String getNoticeBody() {
        return noticeBody;
    }

    public String getNoticeDate() {
        return noticeDate;
    }


//    private String getDateTime() {
//    import java.text.DateFormat;
//    import java.text.SimpleDateFormat;
//    import java.util.Date;
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        Date date = new Date();
//        return dateFormat.format(date);
//        String date = getDateTime();
//        System.out.println(date);
//    }
}
