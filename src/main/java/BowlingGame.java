package main.java;
import java.util.Scanner; 
public class BowlingGame {
	public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);  
        int[][] scores = new int[11][4];  
  
        for (int i = 0; i < scores.length; i++) {//ѭ��11��  
            if (i < scores.length - 1) {//ѭ��ǰ10��  
                System.out.printf("�������%d�֣���1�δ򵹵ĸ�����", i + 1);  
                scores[i][0] = sc.nextInt();  
                if (scores[i][0] < 10 || i == 9) {//ǰ9�� ����10 ���ټǵڶ��η��� ����10��������ζ���2��  
                    System.out.printf("�������%d�֣���2�δ򵹵ĸ�����", i + 1);  
                    scores[i][1] = sc.nextInt();  
                }  
            } else if (scores[i - 1][0] + scores[i - 1][1] >= 10) {//��10��10������ 11�ּ�һ�η���  
                System.out.printf("�������%d��,��%d�δ򵹵ĸ�����", i, 3);  
                scores[i][0] = scores[i][2] = sc.nextInt();  
            }  
        }  
  
        for (int i = 0; i < scores.length-1; i++) {//ǰ11��  
            if (scores[i][0] == 10 && i != 9) {  
                if (scores[i + 1][0] == 10 && i < 8){ //ǰ8�֣�һ��10�� �ͼǺ���2Ͷ��ķ���  
                    scores[i][2] = scores[i][0] + scores[i + 1][0]  + scores[i + 2][0];  
                }else if (scores[i + 1][0] != 10 || i == 8){//��9��10�� �ǵ�10��2�εķ���  
                    scores[i][2] = scores[i][0]  + scores[i + 1][0]  + scores[i + 1][1];  
                }  
            }else{                
                if (scores[i][0] + scores[i][1] == 10 && i < 9){//ǰ9�� ����10�� �������ֵ�һ�εķ���  
                    scores[i][2] = scores[i][0] + scores[i][1] + scores[i + 1][0];  
                }else{  
                    scores[i][2] = scores[i][0] + scores[i][1];//2�β���10�� �ͼ���ô��  
                }  
            }  
        }  
        //���ۼƻ���  
        scores[0][3] = scores[0][2];  
        for(int i = 1; i < scores.length;i++ ){  
                scores[i][3]=scores[i][2] + scores[i - 1][3];  
        }  
        //��ӡ����  
        for(int i = 0 ; i < scores.length; i++){  
            for(int j = 0 ; j < scores[i].length; j++){  
                System.out.print(scores[i][j] + "\t");  
            }  
            System.out.println("\t��" + (i + 1) +"��\n");  
        }  
    }  
}  

