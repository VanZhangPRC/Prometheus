//package van.illusion.prometheus.Frankenstein;
//
//import com.alibaba.fastjson.JSONObject;
//import com.gddxit.dxbase.notify.support.NotifySupporter;
//import com.gddxit.dxbase.notify.support.dict.EMsgType;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.client.ResponseErrorHandler;
//import org.springframework.http.client.ClientHttpResponse;
//import com.gddxit.dxbase.notify.support.dict.ESMSBizType;
//import com.gddxit.dxbase.notify.support.dto.Message;
//// ************************************************************
//import org.pentaho.di.core.exception.KettleException;
//import org.pentaho.di.trans.step.StepDataInterface;
//import org.pentaho.di.trans.step.StepMetaInterface;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//
//public class KettleUserDefinedJavaClass {
//
//
//    public boolean processRow(StepMetaInterface smi, StepDataInterface sdi) throws KettleException {
//
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat originFormat = new SimpleDateFormat("HH:mm");
//
//
//        try {
//            format.format(originFormat.parse(""));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//        if (first) {
//            first = false;
//        }
//
//
//        Object[] inR = getRow();
//
//        if (inR == null) {
//            setOutputDone();
//            return false;
//        }
//
//
//        String timerTime = "08:00";
//        Message message = new Message();
//        JSONObject jsonObject = new JSONObject();
//        message.setType(EMsgType.SMS.name());
//        message.setSubType(ESMSBizType.getByValue(bizType).name());
//        jsonObject.put();
//
//        NotifySupporter notifySupporter = new NotifySupporter();
//
//
//        notifySupporter.postMessage()
//        // It is always safest to call createOutputRow() to ensure that your output row's Object[] is large
//        // enough to handle any new fields you are creating in this step
//
//
//
//        Object[] outR = createOutputRow(inR, data.outputRowMeta.size());
//
//
//
//        /* TODO: Your code here. (See Sample)
//
//        // Get the value from an input field
//        String foobar = get(Fields.In, "a_fieldname").getString(r);
//
//        foobar += "bar";
//
//        // Set a value in a new output field
//        get(Fields.Out, "output_fieldname").setValue(r, foobar);
//
//        */
//        // Send the row on to the next step.
//        putRow(data.outputRowMeta, outR);
//
//        return true;
//    }
//
//
//}
