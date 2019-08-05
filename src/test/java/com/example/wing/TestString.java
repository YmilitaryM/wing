package com.example.wing;

import com.example.wing.protocol.ProtocolEx;
import com.example.wing.protocol.utils.ProtocolUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestString {
    private String str = "[HE: 55 00] [DE[2]AB] [DE[2]AB] [CRC16]";

    @Test
    public void ContextLoad() {

        ProtocolUtils protocolUtils = new ProtocolUtils();
        protocolUtils.explainTag(str);

        ProtocolEx protocolEx = new ProtocolEx();
        byte[] data = new byte[8];
        data[0] = 55;
        data[1] = 00;
        data[2] = 01;
        data[3] = 19;
        data[4] = 02;
        data[5] = 04;
        data[6] = 66;
        data[7] = 77;


        protocolEx.decode(str, data);


        /**
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i<str.length(); i++) {
            String value = str.substring(i, i+1);
            if (value.equals(" "))
                continue;;
            queue.offer(str.substring(i, i + 1));
        }
//        System.err.println(queue.toString());
//        String[] tags = new String[100];
        ArrayList<String> t = new ArrayList<String>();

        String tempString = "";

        boolean flag = false;
        int innerTagNumber = 0;
        int index = 0;
        for (String q :queue) {
            //System.err.println(q);
            if (q.equals("[") && innerTagNumber == 0 && flag == false) {
                System.err.println("1");
                flag = true;
                tempString = tempString.concat(q);
                System.err.println(tempString);
            }
            else if (q.equals("[")) {
                System.err.println("2");
                innerTagNumber++;
                tempString = tempString.concat(q);
                System.err.println(tempString);
            }
            else if (q.equals("]") && innerTagNumber == 0) {
                System.err.println("3");
                flag = false;
                tempString = tempString.concat(q);
                System.err.println(tempString);
                //tags[index] = tempString;
                t.add(tempString);
                index++;
                tempString = "";

            }
            else if (q.equals("]") && innerTagNumber != 0) {
                System.err.println("4");
                tempString = tempString.concat(q);
                innerTagNumber--;
                System.err.println(tempString);
            }
            else {
                System.err.println("5");
                tempString = tempString.concat(q);
                System.err.println(tempString);
            }
        }
        System.err.println(t.toString());

//        HeadTag headTag = new HeadTag();
//        System.err.println(headTag.getHeadTag(t).toString());


        ExplainDataDescrible explainDataDescrible = new ExplainDataDescrible();
        List arg = t.subList(1, t.size());
        System.err.println(arg.toString());
        List list = explainDataDescrible.explainDataTag(t.subList(1, t.size()));
        System.err.println(list.toString());
         */

//        List<String> lastTag = t.subList(1, t.size());
//        boolean iflag = false;
//        int ileft = 0;
//        int iright = 0;
//        for (String lT: lastTag) {
//            for(int i=0; i<lT.length(); i++){
//                if (lT.equals("[") && )
//            }
//        }
        /**
        //String test = "[DE[2]AB]";
        //String test ="[SN[2]]";
        String test = "[SE:1]";
        Queue<String> newQueue = new LinkedList<String>();
        for (int i = 0; i<test.length(); i++) {
            String value = test.substring(i, i+1);
            if (value.equals(" "))
                continue;;
            newQueue.offer(test.substring(i, i + 1));
        }
        boolean start = false;
        String symbol = "";
        String data = "";
        String order = "";
        boolean end = false;
        int number = 0;
        for(String s :newQueue) {
            //System.err.println(s);
            if (s.equals("|")){
                continue;
            }
            if(s.equals("[") && !start) {
                start = true;
                //symbol = symbol.concat(s);
            }
            else if ((s.equals("[") && start) || s.equals(":")) {
                number++;
            }
            else if (s.equals("]") && number >0) {
                // save data
                number = 0;
                end = true;
            }
            else if (s.equals("]")) {
                break;
            }
            else if (number == 0 && end ) {
                order = order.concat(s);
            }
            else if (start && !end && number == 0){
                symbol = symbol.concat(s);
            }
            else if (number != 0 ){
                data = data.concat(s);
            }
            else
                order = order.concat(s);

        }
        System.err.println(symbol);
        System.err.println(data);
        System.err.println(order);
         */

    }

    public void handleSingletag(String tag) {
        tag.toCharArray();
    }
}
