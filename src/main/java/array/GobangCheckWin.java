package array;

/**
 * 五子棋判断输赢
 */
public class GobangCheckWin {
    public boolean isWon(int[][] board, int x, int y, char color) {
        int count = 1;      //本身一点为 1
        int posX = 0;
        int posY = 0;
        /**判断水平方向上的胜负
         /* 将水平方向以传入的点x上的y轴作为分隔线分为两部分
         * 先向左边遍历，判断到的相同的连续的点  count++
         */
        for (posX = x - 1; posX > 0; posX--) {
            if (board[posX][y] == color) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                break;
            }
        }    //向右边遍历
        for (posX = x + 1; posX <= 15; posX++) {
            if (board[posX][y] == color) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                break;
            }
        }
        /**判断垂直方向上的胜负
         /* 将垂直方向以传入的点y上的x轴作为分隔线分为两部分
         * 先向上遍历，判断到的相同的连续的点  count++
         */
        for (posY = y - 1; posY > 0; posY--) {
            if (board[x][posY] == color) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                break;
            }
        }//向下遍历
        for (posY = y + 1; posY <= 15; posY++) {
            if (board[x][posY] == color) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                break;
            }
        }
        /**判断左上右下方向上的胜负
         * 以坐标点为分割线，将棋盘分为左右两个等腰三角形
         * 先判断左边的
         */
        for (posX = x - 1, posY = y - 1; posX > 0 && posY > 0; posX--, posY--) {
            if (board[posX][posY] == color) {
                count++;
                if (count >= 5) {
                    count = 1;
                    return true;
                }
            } else {
                break;
            }
        }//判断右边的
        for (posX = x + 1, posY = y + 1; posX <= 15 && posY <= 15; posX++, posY++) {
            if (board[posX][posY] == color) {
                count++;
                if (count >= 5) {
                    count = 1;
                    return true;
                }
            } else {
                break;
            }
        }
        /**判断右下左下方向上的胜负
         * 以坐标点为分割线，将棋盘分为左右两个等腰三角形
         * 先判断左边的
         */
        for (posX = x + 1, posY = y - 1; posX <= 15 && posY > 0; posX++, posY--) {
            if (board[posX][posY] == color) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                break;
            }
        }//判断右边的
        for (posX = x - 1, posY = y + 1; posX > 0 && posY <= 15; posX--, posY++) {
            if (board[posX][posY] == color) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }
}
