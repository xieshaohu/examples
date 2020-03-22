package examples.spring.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Body {

    private int code = 200;
    private String msg = "";

    @JsonProperty("page_num")
    private long pageNum;
    private long total;
    @JsonProperty("page_size")
    private long pageSize;

    private Object data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public long getPageNum() {
        return pageNum;
    }

    public long getTotal() {
        return total;
    }

    public long getPageSize() {
        return pageSize;
    }

    public Object getData() {
        return data;
    }

    public static Body build() {
        return new Body();
    }

    public Body ok(String msg) {
        this.code = 200;
        this.msg = msg;
        return this;
    }

    public Body ok(String msg, Object data) {
        this.code = 200;
        this.msg = msg;
        var map = new HashMap<String, Object>();
        map.put("data", data);
        this.data = map;
        return this;
    }

    public Body ok(String msg, Map<String, Object> data) {
        this.code = 200;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public Body ok(String msg, PageInfo pageInfo) {
        this.code = 200;
        this.msg = msg;
        this.data = pageInfo.getList();
        this.pageNum = pageInfo.getPageNum();
        this.total = pageInfo.getTotal();
        this.pageSize = pageInfo.getPageSize();
        return this;
    }

    public Body fail(String msg) {
        this.code = 400;
        this.msg = msg;
        return this;
    }

    public Body fail(String msg, Map<String, Object> data) {
        this.code = 400;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public Body internalServerError(String msg) {
        this.code = 500;
        this.msg = msg;
        return this;
    }

    public Body internalServerError(String msg, Map<String, Object> data) {
        this.code = 500;
        this.msg = msg;
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Body.class.getSimpleName() + "[", "]")
                .add("code=" + code)
                .add("msg='" + msg + "'")
                .add("data=" + data)
                .toString();
    }
}