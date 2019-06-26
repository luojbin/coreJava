package com.loyofo.core.s14_concurrent.e13_complateFuture;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 可以按顺序处理分属不同线程的任务
 * <p>
 * 模拟, 教师编试卷, 然后发给学生完成, 学生完成后老师批改试卷
 */
public class ComplFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<ExamPaper> result = CompletableFuture.supplyAsync(ExamPaper::new)
                .thenApplyAsync((e) -> {
                    System.out.println(Thread.currentThread() + "正在做题");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    e.setStudentName("luojbin");
                    return e;
                })
                .thenApplyAsync((e) -> {
                    System.out.println(Thread.currentThread() + e.getStudentName() + "已交卷, 正在判卷...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    e.setScore((int) (Math.random() * 100));
                    System.out.println(Thread.currentThread() + e.getStudentName() + "的卷子已打分");
                    return e;
                });
        System.out.println("来等待结果吧...");
        System.out.println(result.get());
    }
}

class ExamPaper {

    public static final int NEW = 0;
    public static final int DONE = 1;

    private String studentName;
    private int score;

    ExamPaper() {
        System.out.println(Thread.currentThread() + "正在创建对象");
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ExamPaper{" +
                "studentName='" + studentName + '\'' +
                ", score=" + score +
                '}';
    }
}
