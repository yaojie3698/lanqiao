package org.lanqiao.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *处理日期的工具类
 */
public class DateUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 使用全局变量： sdf，将字符串转换为java.util.Date类型并返回
	 * 注意，不能声明任何形式的异常抛出，否则测试用例无法通过
	 * @param stringDate
	 * @return
	 */
	public static Date convertFromStringToDate(String stringDate) {
		// 补全代码：
		Date date = null;
		try {
			date = sdf.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 使用全局变量： sdf，将日期转换成字符串
	 * @param date 需要被转换的日期
	 * @return 转换之后的字符串形式的日期
	 */
	public static String convertFromDateToString(Date date) {
		// 补全或替换代码
		return sdf.format(date);
	}
}