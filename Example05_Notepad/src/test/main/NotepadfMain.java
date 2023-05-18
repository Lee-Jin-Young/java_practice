package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotepadfMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("파일 명을 입력하세요.\n 예시)가나다.txt \n");
		String fileName = scan.nextLine();
		
		System.out.print("한 문장 입력");
		String msg = scan.nextLine();

		File f = new File("C:/Users/acorn/acorn202304/myFolder/"+fileName);

		try {
			if (!f.exists()) {
				f.createNewFile();
				System.out.println(fileName+"파일을 만들었습니다.");
			}

			FileWriter fw = new FileWriter(f); // 파일에 문자열을 출력 할 수 있는 객체

			fw.write(msg);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
