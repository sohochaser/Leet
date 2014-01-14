package com.leet.dict;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        if (tokens == null) {
            return 0;
        }

        String[] tmp = new String[tokens.length];
        int top = 0;

        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];

            if (str.length() == 1) {
                int op = 0;
                if (str.equals("+")) {
                    op = 1;
                } else if (str.equals("-")) {
                    op = 2;
                } else if (str.equals("*")) {
                    op = 3;
                } else if (str.equals("/")) {
                    op = 4;
                }
                if (op > 0) {
                    Integer right = Integer.parseInt(tmp[--top]);
                    Integer left = Integer.parseInt(tmp[--top]);
                    int result = 0;
                    switch (op) {
                    case 1:
                        result = left + right;
                        break;
                    case 2:
                        result = left - right;
                        break;
                    case 3:
                        result = left * right;
                        break;
                    case 4:
                        result = left / right;
                        break;
                    }
                    tmp[top++] = String.valueOf(result);
                } else {
                    tmp[top++] = str;
                }
            } else {
                tmp[top++] = str;
            }
        }
        if (top > 0) {
            return Integer.parseInt(tmp[0]);
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] tokens = new String[] { "2", "1", "+", "3", "*" };
        System.out.println(new EvalRPN().evalRPN(tokens));
    }
}