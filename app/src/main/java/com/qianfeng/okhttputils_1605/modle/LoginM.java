package com.qianfeng.okhttputils_1605.modle;

/**
 * Created by dupengfei on 16/8/15.
 */
public class LoginM {


    /**
     * result : 1
     * msg : 登录成功
     * data : {"id":"1","username":"kooeasy","userpass":"ZmU1MTgxYTJiODA4MTkzMDY0YmZiMWJlZWI5NjNkZTk=","usersex":"","useremail":"","nickname":"专骗小女生","birthday":"","portrait":"20150826/55dd75d78083b.jpg","signature":""}
     */

    private int result;
    private String msg;
    /**
     * id : 1
     * username : kooeasy
     * userpass : ZmU1MTgxYTJiODA4MTkzMDY0YmZiMWJlZWI5NjNkZTk=
     * usersex :
     * useremail :
     * nickname : 专骗小女生
     * birthday :
     * portrait : 20150826/55dd75d78083b.jpg
     * signature :
     */

    private DataEntity data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        private String id;
        private String username;
        private String userpass;
        private String usersex;
        private String useremail;
        private String nickname;
        private String birthday;
        private String portrait;
        private String signature;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserpass() {
            return userpass;
        }

        public void setUserpass(String userpass) {
            this.userpass = userpass;
        }

        public String getUsersex() {
            return usersex;
        }

        public void setUsersex(String usersex) {
            this.usersex = usersex;
        }

        public String getUseremail() {
            return useremail;
        }

        public void setUseremail(String useremail) {
            this.useremail = useremail;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }
    }
}
