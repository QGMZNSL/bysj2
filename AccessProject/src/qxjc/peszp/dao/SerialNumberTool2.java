package qxjc.peszp.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

class SerialNumberTool2 {

    private static SerialNumberTool2 serialNumberTool = null;
    private static SimpleDateFormat yMd = new SimpleDateFormat("yyyyMMdd");
    //用于自增长的标识
    private int flag;
    //用于记录日期
    private Date date;


    SerialNumberTool2() {
        if(date == null || !(yMd.format(new Date()).equals(yMd.format(date)))){
            date = new Date();
            flag = 1;
        }
    }

    /**
     * 判断是否改变
     */
    private  void checkChangeDay(){
        if(date == null || !(yMd.format(new Date()).equals(yMd.format(date)))){
            date = new Date();
            flag = 1;
        }
    }


    /**
     * 取得PrimaryGenerater的单例实现
     *
     * @return
     */
    public static  SerialNumberTool2 getInstance() {
        if (serialNumberTool == null) {
            synchronized (SerialNumberTool2.class) {
                if (serialNumberTool == null) {
                    serialNumberTool = new SerialNumberTool2();
                }
            }
        }
        return serialNumberTool;
    }


    /**
     * 生成下一个编号,前缀自动补全 0
     * params:
     * 2.places 需要补全的总位数
     *
     */
    public synchronized String generaterNextNumber(int places) {
        checkChangeDay();
        StringBuffer stringBuffer = new StringBuffer();
        int numPlaces = Integer.toString(flag).length();
        //数字位数小于需要补全的总位数，需要补全0
        if(numPlaces < places ){
            for (int i = 0; i < places - numPlaces; i++) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toString(flag));
        }
        else stringBuffer.append(Integer.toString(flag));
        flag++;
        return stringBuffer.toString();
    }

    /**
     * 避免当断网后重连或者服务器重启时导致标识flag清0，可以手动设置flag的开始点
     * @param args
     */
    public void operateFlag(int position){
        this.flag = position;
    }

    public static void main(String[] args) {
        for (int i = 0; i <10000 ; i++) {
            System.out.println(SerialNumberTool2.getInstance().generaterNextNumber(6));
        }
    }
}
