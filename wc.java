package getdata;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.IOException;
import java.io.InputStreamReader;

public class wc {
	@SuppressWarnings("resource")
	public static void main (String[] args) {
		System.out.println("ע�⣺��Ҫ��ȡ���ļ��ڸ�Ŀ¼��ֻ�������ļ�������Ҫ��ȡ���ļ�������·����Ҫ��·��һ�����롣");
		System.out.println("��ȡָ��:-c  �����ļ����ַ���");
		System.out.println("��ȡָ��:-w  �����ļ��ĵ�����");
		System.out.println("��ȡָ��:-l  �����ļ�������");
		System.out.println("����ָ��:-s  ����ļ��������ݹ鴦��Ŀ¼�·����������ļ�");
		System.out.println("�밴�������ȡָ���Լ��ļ�����");
		Scanner or =new Scanner(System.in);
		String order=or.nextLine();//�Ӽ����������ȡָ��
		String filename=or.nextLine();//�Ӽ����������ļ���
		if(order.trim().equals("-s")) {
			System.out.println("�밴�������ȡָ���Լ��ļ�����������ʽ������*.c");
			Scanner sp =new Scanner(System.in);
			String uper=sp.nextLine();//�Ӽ����������ȡָ��
			String tiao=sp.nextLine();//�Ӽ����������ļ�����
		}
		if(order.trim().equals("-c")) {
			getchars(filename);
		}//����ָ��-c����ļ��ַ���
		else if(order.trim().equals("-w")) {
			getwords(filename);
		}//����ָ��-w����ļ�������
		else if(order.trim().equals("-l")) {
			getlines(filename);
		}//����ָ��-l����ļ�����
		else {
			System.out.println("ָ���������");
		}
		
	}

	public static void getchars(String filename1) {
		File file = new File(filename1);
		if(!file.exists()) {
			file.mkdirs();////ָ��·���µ��ļ�Ҫ�ǲ����ھʹ���
		}
		Reader reader = null;
		
		try {
			reader = new InputStreamReader(new FileInputStream(file));
			int temp=0;
			while ((reader.read()) !=-1) {
				temp=temp+1;//ÿ��ȡһ���ַ�temp+1
				}
			System.out.println("���ļ����ַ���:"+temp);//���temp
			reader.close();//�ر�������
		}catch (IOException ex) {
			ex.printStackTrace();
		}
	}
		
	public static void getwords(String filename1) {
			File file = new File(filename1);
			if(!file.exists()) {
				file.mkdirs();////ָ��·���µ��ļ�Ҫ�ǲ����ھʹ���
			}
			Reader reader = null;
			
			try {
				reader = new InputStreamReader(new FileInputStream(file));
				int temp=0;
				int tempchar=0;
				while ((tempchar = reader.read()) !=-1) {
					if(((char)tempchar) == 32 || ((char)tempchar) == '\n'){
					temp=temp+1;//ÿ��ȡ��һ���ո�temp+1
					}
					}
				if(temp==0) {
				System.out.println("���ļ��ĵ�����:"+temp);//�ļ�Ϊ�����0
				}
				else {
					System.out.println("���ļ��ĵ�����:"+(temp+1));//�ļ���Ϊ�����temp+1
				}
				reader.close();//�ر�������
			
			}catch (IOException ex) {
				ex.printStackTrace();
	   }
	
}
	public static void getlines(String filename1) {
		File file = new File(filename1);
		if(!file.exists()) {
			file.mkdirs();////ָ��·���µ��ļ�Ҫ�ǲ����ھʹ���
		}
		Reader reader = null;
		
		try {
			reader = new InputStreamReader(new FileInputStream(file));
			int temp=0;
			int tempchar=0;
			while ((tempchar = reader.read()) !=-1) {
				if(((char)tempchar) == '\n'){
				temp=temp+1;//ÿ��ȡ��һ�����з�temp+1
				}}
			if(temp==0) {
				System.out.println("���ļ�������:"+temp);//�ļ�Ϊ�����0
				}
				else {
					System.out.println("���ļ�������:"+(temp+1));//�ļ���Ϊ�����temp+1
				}
			reader.close();//�ر�������
		
		}catch (IOException ex) {
			ex.printStackTrace();
   }

}
	}
	
		
	


