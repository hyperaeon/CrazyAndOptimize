package com.interview.practice;

import org.springframework.util.StringUtils;

/**
 * 输入一串字符串，输出压缩后的字符串
 * 如输入字符串为"Iloofeiafeaafeaad"，输出"Ilofeiafead"
 * @author ly
 * @date 2018年8月2日 上午10:25:33
 */
public class CompressWords {

	public static void main(String[] args) {
//		String input = "Iloofeiafeaafeaad";
//		String input = "ooooooooooooooooosooooosoososoo";
//		String input = "o";
		String input = "我们我们我们是";
		String output = handleDuplicateLetters(input);
		output = handleDuplicateWords(output);
		System.out.println("output:" + output);
		System.out.println("index:" + input.lastIndexOf("feaa"));
		System.out.println("是否包含:" + isStringContains(input, ""));
		
	}
	
	
	/**
	 * 对连续出现的字母进行压缩，如输入"Iloofeiafeaafeaad"，返回"Ilofeiafeafead"
	 * 实现核心思想：当前字母如果和前一个字母相同则不放，如果不相同，则放入
	 * @param words
	 * @return
	 * ly
	 */
	private static String handleDuplicateLetters(String words) {
		if (StringUtils.isEmpty(words)) {
			return words;
		}
		char[] inputs = words.toCharArray();
		String preview = String.valueOf(inputs[0]);
		StringBuilder output = new StringBuilder(preview);
		String current = "";
		int index = 0;
		for (int i = 1 ; i < inputs.length; i++) {
			current = String.valueOf(inputs[i]);
			if (!preview.equals(current)) {//如果当前的字母与上一个字母不一样，将preview中的值追加到output中；并且将当前字母赋值给preview变量
				preview = current;
				index = 0;
			} else {
				index ++;
			}
			if (index == 0) {//index为0说明当前的字母与之前的不同，加入到output中
				output.append(current);
			}
		}
		return output.toString();
	}
	
	/**
	 * 对重复的词进行压缩，如输入"Ilofeiafeafead"，输出"Ilofeiafead"
	 * @param words
	 * @return
	 * ly
	 */
	private static String handleDuplicateWords(String words) {
		if (StringUtils.isEmpty(words)) {
			return words;
		}
		StringBuilder output = new StringBuilder();
		String outputString = "";
		String preview = "";//上一个词
		String currentLetter = "";//当前字符
		char[] inputs = words.toCharArray();
		int index = 0;
		for (int i = 0; i < inputs.length; i++) {
			outputString = output.toString();
			currentLetter = String.valueOf(inputs[i]);
			if (isStringContains(outputString, preview)
					&& isStringContains(outputString, preview + currentLetter)) {//如果output包含preview和preview+currentLetter字符串，则preview添加currentLetter，并且继续变量
				preview += currentLetter;
			} else if (isStringContains(outputString, preview)
					&& !isStringContains(outputString, preview + currentLetter)) {//如果output包含preview，但不包含preview+currentLetter字符串
				index = outputString.lastIndexOf(preview);//preview在output中的最后一个索引位置
				if (index + preview.length() != outputString.length()) {//如果preview不是在outputString的最后位置，则说明不是重复的字符串，preview和currentLetter都应该添加到output中
					output.append(preview + currentLetter);
					preview = "";//preview重置空字符串
				} else {
					preview = currentLetter;
				}
			} else if (!isStringContains(outputString, preview)
					&& isStringContains(outputString, preview + currentLetter)) {//如果output不包含preview，但是包含preview + currentLetter，此场景为preview是空字符串
				if (isLast(outputString, currentLetter)) {//如果preview与output的最后一个字符重复，则舍去
					preview = "";//preview重置空字符串
				} else {//此时preview赋值为currentLetter
					preview = currentLetter;
				}
			} else {//output既不包含preview，也不包含preview + currentLetter，此场景为preview是空字符串，并且output也不包含currentLetter字符
				output.append(preview + currentLetter);
				preview = "";//preview重置空字符串
			}
			if (i == inputs.length - 1) {
				output.append(preview);
			}
		}
		return output.toString();
	}
	
	/**
	 * str1是否包含str2
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 * ly
	 */
	private static boolean isStringContains(String str1, String str2) {
		int lastIndex = str1.lastIndexOf(str2);
		return lastIndex >= 0 && lastIndex < str1.length();
	}
	
	/**
	 * 判断str2是否为str1的最后一个字符
	 * @param str1
	 * @param str2
	 * @return
	 * ly
	 */
	private static boolean isLast(String str1, String str2) {
		return str1.lastIndexOf(str2) == str1.length() - 1;
	}
	
}
