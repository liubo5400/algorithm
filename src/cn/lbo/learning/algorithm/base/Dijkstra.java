package cn.lbo.learning.algorithm.base;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author bjliubo
 * @Date 2024/2/22 15:40
 * @PackageName:cn.lbo.learning.algorithm.base
 * @ClassName: Dijkstra
 * @Description: 单源最短路径算法
 * 算法使用了广度优先搜索解决赋权有向图或者无向图的单源最短路径问题，算法最终得到一个最短路径树。
 * 该算法常用于路由算法或者作为其他图算法的一个子模块。
 * @Version 1.0
 */
public class Dijkstra {

    static class node {
        int x; //节点编号
        int lenth;//长度

        public node(int x, int lenth) {
            this.x = x;
            this.lenth = lenth;
        }
    }

    public static void main(String[] args) {

        int[][] map = new int[6][6];//记录权值，顺便记录链接情况，可以考虑附加邻接表
        initmap(map);//初始化

        boolean bool[] = new boolean[6];//判断是否已经确定
        int len[] = new int[6];//长度
        for (int i = 0; i < 6; i++) {
            len[i] = Integer.MAX_VALUE;
        }
        Queue<node> q1 = new PriorityQueue<node>(Comparator.comparingInt(o -> o.lenth));
        len[0] = 0;//从0这个点开始
        q1.add(new node(0, 0));
        while (!q1.isEmpty()) {
            node t1 = q1.poll();
            int index = t1.x;//节点编号
            int length = t1.lenth;//节点当前点距离
            bool[index] = true;//抛出的点确定
            for (int i = 0; i < map[index].length; i++) {
                if (map[index][i] > 0 && !bool[i]) {
                    node node = new node(i, length + map[index][i]);
                    if (len[i] > node.lenth)//需要更新节点的时候更新节点并加入队列
                    {
                        len[i] = node.lenth;
                        q1.add(node);
                    }
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(len[i]);
        }
    }

    private static void initmap(int[][] map) {
        map[0][1] = 2;
        map[0][2] = 3;
        map[0][3] = 6;
        map[1][0] = 2;
        map[1][4] = 4;
        map[1][5] = 6;
        map[2][0] = 3;
        map[2][3] = 2;
        map[3][0] = 6;
        map[3][2] = 2;
        map[3][4] = 1;
        map[3][5] = 3;
        map[4][1] = 4;
        map[4][3] = 1;
        map[5][1] = 6;
        map[5][3] = 3;
    }
}
