package com.qianfeng.okhttputils_1605.modle;

/**
 * Created by dupengfei on 16/8/15.
 */
public class RegistM {


    /**
     * result : 1
     * msg : 恭喜！注册成功
     * data : {"username":"pig","userpass":"MTRlMWI2MDBiMWZkNTc5ZjQ3NDMzYjg4ZThkODUyOTE=","nickname":"小 "}
     */

    private int result;
    private String msg;
    /**
     * username : pig
     * userpass : MTRlMWI2MDBiMWZkNTc5ZjQ3NDMzYjg4ZThkODUyOTE=
     * nickname : 小
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
        private String username;
        private String userpass;
        private String nickname;

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

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "username='" + username + '\'' +
                    ", userpass='" + userpass + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginM{" +
                "result=" + result +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
