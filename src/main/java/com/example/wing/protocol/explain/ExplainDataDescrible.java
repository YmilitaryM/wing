package com.example.wing.protocol.explain;

import com.example.wing.protocol.tag.DataTag;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ExplainDataDescrible {
    private List tagList;
    public List explainTag(String dataDescible) {
        return explainTag(dataDescible);
    }


    public List explain(String tagDescrible) {
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i<tagDescrible.length(); i++) {
            String value = tagDescrible.substring(i, i+1);
            if (value.equals(" "))
                continue;;
            queue.offer(tagDescrible.substring(i, i + 1));
        }
        ArrayList<String> tags = new ArrayList<String>();

        String tempString = "";

        boolean flag = false;
        int innerTagNumber = 0;
        for (String q :queue) {
            if (q.equals("[") && innerTagNumber == 0 && flag == false) {
                flag = true;
                tempString = tempString.concat(q);
            }
            else if (q.equals("[")) {
                innerTagNumber++;
                tempString = tempString.concat(q);
            }
            else if (q.equals("]") && innerTagNumber == 0) {
                flag = false;
                tempString = tempString.concat(q);
                tags.add(tempString);
                tempString = "";

            }
            else if (q.equals("]") && innerTagNumber != 0) {
                tempString = tempString.concat(q);
                innerTagNumber--;
            }
            else {
                tempString = tempString.concat(q);
            }
        }
        return tags;
    }

    public List<String> explainDataTag(List<String> tagList) {
        ArrayList list = new ArrayList();
        for (int i = 0; i<tagList.size(); i ++) {
           DataTag tag = getTag(tagList.get(i));
             list.add(tag);
        }
        return list;
    }

    public DataTag getTag(String tagDataDescribe) {
        DataTag tag = new DataTag();
        Queue<String> newQueue = new LinkedList<String>();
        for (int i = 0; i<tagDataDescribe.length(); i++) {
            String value = tagDataDescribe.substring(i, i+1);
            if (value.equals(" "))
                continue;;
            newQueue.offer(tagDataDescribe.substring(i, i + 1));
        }
        boolean start = false;
        String symbol = "";
        String data = "";
        String order = "";
        String length = "";
        boolean end = false;
        int number = 0;
        int snumber = 0;
        for(String s :newQueue) {
            //System.err.println(s);
            if (s.equals("|")){
                continue;
            }
            if(s.equals("[") && !start) {
                start = true;
                //symbol = symbol.concat(s);
            }
            else if (s.equals(":")) {
                snumber++;
            }
            else if ((s.equals("[") && start)) {
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
            else if (start && !end && number == 0 && snumber == 0){
                symbol = symbol.concat(s);
            }
            else if (number != 0 ){
                length = length.concat(s);
            }
            else if (snumber != 0) {
                data = data.concat(s);
            }
            else
                order = order.concat(s);

        }
        tag.setData(data);
        tag.setOrder(order);
        tag.setSymbol(symbol);
        //System.err.println(length);
        if (length.equals("")) {
            tag.setLength(0);
        }
        else
            tag.setLength(Integer.parseInt(length));

        return tag;
    }

}
