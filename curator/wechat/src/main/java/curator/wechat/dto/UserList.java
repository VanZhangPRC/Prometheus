package curator.wechat.dto;

import java.util.List;

public class UserList {

    private Integer tota;
    private Integer count;

    private Data data;

    public static class Data {
        private List<String> openid;
        private String nextOpenid;

        public List<String> getOpenid() {
            return openid;
        }

        public void setOpenid(List<String> openid) {
            this.openid = openid;
        }

        public String getNextOpenid() {
            return nextOpenid;
        }

        public void setNextOpenid(String nextOpenid) {
            this.nextOpenid = nextOpenid;
        }
    }

    public Integer getTota() {
        return tota;
    }

    public void setTota(Integer tota) {
        this.tota = tota;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
