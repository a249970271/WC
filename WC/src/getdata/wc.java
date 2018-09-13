package getdata;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class wc {
	@SuppressWarnings("resource")
	public static void main (String[] args) {
		System.out.println("ע�⣺��Ҫ��ȡ���ļ��ڸ�Ŀ¼��ֻ�������ļ�������Ҫ��ȡ���ļ�������·����Ҫ��·��һ�����롣");
		System.out.println("��ȡָ��:-c  �����ļ����ַ���");
		System.out.println("��ȡָ��:-w  �����ļ��ĵ�����");
		System.out.println("��ȡָ��:-l  �����ļ�������");
		System.out.println("��ȡָ��:-s  �����ļ���������ע�������Լ���������");
		System.out.println("��ȡָ��:-all  ����������������");
		System.out.println("�������ȡָ��س��������ļ�����");
		Scanner or =new Scanner(System.in);
		String order=or.nextLine();//�Ӽ����������ȡָ��
		String filename=or.nextLine();//�Ӽ����������ļ���
		if(order.trim().equals("-c")) {
			getchars(filename);
		}//����ָ��-c����ļ��ַ���
		else if(order.trim().equals("-w")) {
			getwords(filename);
		}//����ָ��-w����ļ�������
		else if(order.trim().equals("-l")) {
			getlines(filename);
		}//����ָ��-l����ļ�����
		else if(order.trim().equals("-s")) {
			getkonglines(filename);
		}//����ָ��-l����ļ�����
		else if(order.trim().equals("-all")) {
			getchars(filename);
			getwords(filename);
			getlines(filename);
			getkonglines(filename);
		}//����ָ��-l����ļ�����
		else {
			System.out.println("ָ���������");
		}
	}

	public static void getchars(String filename1) {		
		File file = new File(filename1);
		if(!file.exists()) {
			System.out.println("δ�ҵ�Ŀ���ļ���");//ָ��·���µ��ļ��������������δ�ҵ�Ŀ���ļ�
		}else {		
		try {
			FileInputStream fis=(new FileInputStream(file));
			int temp=0;
			while ((fis.read()) !=-1) {
				temp=temp+1;//ÿ��ȡһ���ַ�temp+1
				}
			System.out.println("���ļ����ַ���:"+temp);//���temp
			fis.close();//�ر�������
		}catch (IOException ex) {
			ex.printStackTrace();//�����쳣
		}
		}
	}
		
	public static void getwords(String filename1) {
		File file = new File(filename1);
		if(!file.exists()) {
			System.out.println("δ�ҵ�Ŀ���ļ���");//ָ��·���µ��ļ��������������δ�ҵ�Ŀ���ļ�
		}else {
		try {
			FileInputStream fis=(new FileInputStream(file));
			int temp=0;
			int tempchar=0;
			while ((tempchar = fis.read()) !=-1) {
				if(((char)tempchar) == 32 || ((char)tempchar) == '\n'){
				temp=temp+1;//ÿ��ȡ��һ���ո���з�temp+1
				}
				}
			if(temp==0) {
			System.out.println("���ļ��ĵ�����:"+temp);//�ļ�Ϊ�����0
			}
			else {
				System.out.println("���ļ��ĵ�����:"+(temp+1));//�ļ���Ϊ�����temp+1
			}
			fis.close();//�ر�������
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		}
	  }
		

	public static void getlines(String filename1) {
		File file = new File(filename1);
		if(!file.exists()) {
			System.out.println("δ�ҵ�Ŀ���ļ���");//ָ��·���µ��ļ��������������δ�ҵ�Ŀ���ļ�
		}else {
		try {
			FileInputStream fis=(new FileInputStream(file));
			int temp=0;
			int tempchar=0;
			while ((tempchar = fis.read()) !=-1) {
				if(((char)tempchar) == '\n'){
				temp=temp+1;//ÿ��ȡ��һ�����з�temp+1
				}}
			if(temp==0) {
				System.out.println("���ļ�������:"+temp);//�ļ�Ϊ�����0
				}
				else {
					System.out.println("���ļ�������:"+(temp+1));//�ļ���Ϊ�����temp+1
				}
			fis.close();//�ر�������
		
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		}
      }
	public static void getkonglines(String filename1) {
		int dl = 0, kl = 0, zl = 0;
		String t;
		File file = new File(filename1);
		if(!file.exists()) {
			System.out.println("δ�ҵ�Ŀ���ļ���");//ָ��·���µ��ļ��������������δ�ҵ�Ŀ���ļ�
		}else {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while ((t = br.readLine())!= null) {
					if(t.trim().startsWith("//") == true || t.trim().startsWith("/*")==true ||t.trim().startsWith("}/*")==true || t.trim().startsWith("}//")==true){
						zl=zl+1;
					}
					else if(t.trim().length()==0 || (t.trim().startsWith("}") == true && t.trim().length()==1)) {
						kl=kl+1;
					}
					else {
						dl=dl+1;
					}
				}br.close();

			System.out.println("���ļ��Ŀ�����:"+kl);
			System.out.println("���ļ�ע������"+zl);
			System.out.println("���ļ���������"+dl);
		}catch (IOException ex) {
			ex.printStackTrace();
			}
       }
	}
}
	
		
	


