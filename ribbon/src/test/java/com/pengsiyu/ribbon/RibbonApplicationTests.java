package com.pengsiyu.ribbon;

import com.pengsiyu.ribbon.entity.SalarySum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RibbonApplicationTests {

    @Test
    public void contextLoads() {

    }

    public static void main(String[] args) {
        File file = new File("D:\\temp\\newTest\\random.txt");
        //writerString(file);
        Map<String,SalarySum> stringSalarySumMap =  readString(file);
        List<Map.Entry<String,SalarySum>> list = new ArrayList<Map.Entry<String,SalarySum>>(stringSalarySumMap.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,SalarySum>>() {
            //降序排序
            public int compare(Map.Entry<String, SalarySum> o1,
                               Map.Entry<String, SalarySum> o2) {
                return o2.getValue().getSalarySum().compareTo(o1.getValue().getSalarySum());
            }
        });
        long PeopleNumberSum = 0 ;
//        for(Map.Entry<String,SalarySum> mapping:list){
////            System.out.println(mapping.getKey()+","+mapping.getValue().getSalarySum()+"万,"+mapping.getValue().getPeopleNumber()+"人");
////            PeopleNumberSum += mapping.getValue().getPeopleNumber();
////        }
        list.stream().limit(10).forEach(mapping -> {
            System.out.println(mapping.getKey()+","+mapping.getValue().getSalarySum()+"万,"+mapping.getValue().getPeopleNumber()+"人");
        });
        System.out.println(PeopleNumberSum);
    }

    public static  void  writerString(File file){
        if(!file.exists()){
            file.getParentFile().mkdir();
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        String str = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        Writer writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter(file);
            bufferedWriter = new BufferedWriter(writer);
            for (int i = 0; i <10000000 ; i++) {
                StringBuffer strb = new StringBuffer();
                // StringBuffer类型的可以append增加字符
                for (int j = 0; j < 4 ; j++) {
                    strb.append(str.charAt(random.nextInt(str.length())));
                }
                strb.append(","+random.nextInt(101));
                strb.append(","+random.nextInt(6));
                bufferedWriter.write(strb.toString()+"\r\n");
//            System.out.print("name:"+strb.toString()+"\t");
//            System.out.print("salary:"+random.nextInt(101)+"万"+"\t");
//            System.out.print("bonus："+random.nextInt(6)+"万");
//            System.out.println();
            }
            System.out.println("写入成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                bufferedWriter.flush();
                writer.flush();
                bufferedWriter.close();
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public  static Map<String,SalarySum>  readString(File file){
        Reader reader = null;
        BufferedReader br = null;
        Map<String,SalarySum> mapMap = new HashMap<>();
        try{
            reader = new FileReader(file);
            br = new BufferedReader(reader);
            String str = null;
            while ((str = br.readLine()) != null){
                String strs[] = str.split(",");
                SalarySum  salarySum = null;
                if(mapMap.get(strs[0].substring(0,2)) != null){
                    salarySum = mapMap.get(strs[0].substring(0,2));
                    salarySum.setSalarySum(salarySum.getSalarySum()+Integer.parseInt(strs[1]) * 13 + Integer.parseInt(strs[2]));
                    salarySum.setPeopleNumber(salarySum.getPeopleNumber()+1);
                }else{
                    salarySum = new SalarySum();
                    salarySum.setSalarySum(Integer.parseInt(strs[1]) * 13 + Integer.parseInt(strs[2]));
                    salarySum.setPeopleNumber(1);
                }
                mapMap.put(strs[0].substring(0,2),salarySum);
            }
            System.out.println("读取完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                br.close();
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return mapMap;
    }



}
