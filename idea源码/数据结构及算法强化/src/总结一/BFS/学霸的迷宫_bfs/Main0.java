package 总结一.BFS.学霸的迷宫_bfs;



/*
 * 为甚麽最先侵染到它的是它的最短路径呢？
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Main0 {

	public static void main(String[] args) throws IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		//存储数据；
		char c[][] = new char[n][m];
		for (int i = 0; i <n; i++) {
			c[i] = br.readLine().toCharArray();
		}
		boolean b[][] = new boolean[n][m];
		b[0][0] = true;



		LinkedList<Node>  list = new LinkedList<Node>();
		list.add(new Node(0,0,'.',null));

		//只要list不为空则进行无休止的循环；
		while(!list.isEmpty()){

			//取出头节点，然后将头节点从列表中删除；
			Node temp = list.removeFirst();
			int x = temp.x;
			int y = temp.y;
			//走到目标；
			if(x== n-1 && y== m-1){
				int i = 0;
				StringBuilder sb = new StringBuilder();
				while(temp.node!= null){
					i++;
					sb.insert(0,temp.c);
					temp = temp.node;
				}
				System.out.println(i);
				System.out.println(sb.toString());
				return;
			}

			if(x+1 < n && c[x+1][y] =='0' && ! b[x+1][y]){
				list.addLast(new Node(x+1,y,'D',temp));
				b[x+1][y] = true;
			}

			if(y-1 >=0 && c[x][y-1] == '0' && !b[x][y-1]){
				list.addLast(new Node(x,y-1,'L',temp));
				b[x][y-1] =true;
			}



			if(y+1<m && c[x][y+1] =='0' && !b[x][y+1]){
				list.addLast(new Node(x,y+1,'R',temp));
				b[x][y+1] = true;

			}

			if(x-1>=0 && c[x-1][y] =='0'&& !b[x-1][y]){
				list.addLast(new Node(x-1,y,'U',temp));
					b[x-1][y] = true;
			}


		}

	}


}


//一个坐标一个字符和指向另一个节点的指针构成此节点；
class Node{
	int x;
	int y;
	char c;
	Node node;
	public Node(int x, int y, char c, Node node) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
		this.node = node;
	}

}






































