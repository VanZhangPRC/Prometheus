package van.illusion.prometheus.Frankenstein;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Main {

    public static void main(String[] args) {

//        String str = "{\"code\": \"123\", \"message\": \"hello\"}";
        String str = "{\"code\": {\"message\": \"hello\"}}";
        ApiDockA a = new ApiDockA();
        System.out.println(a.excute(str));

    }


    public static class Output {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class Input<T> {
        private T code;

        public T getCode() {
            return code;
        }

        public void setCode(T code) {
            this.code = code;
        }
    }

    public static class ApiDockA extends ApiDocker<Input<Output>, Output> {


        @Override
        public Output dock(Input<Output> input) {
            return input.getCode();

        }

        @Override
        public String getType() {
            return null;
        }
    }

    public static abstract class ApiDocker<S, T> implements Serializable {

        public String excute(String input) {

            S s;
            try {
                s = JSONObject.parseObject(input, ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
            } catch (JSONException e) {
                return null;
            }


            T t = dock(s);
            String output;
            try {
                output = JSONObject.toJSONString(t);
            } catch (JSONException e) {
                return null;
            }
            return output;
        }

        public abstract T dock(S s);

        public abstract String getType();

    }


}
