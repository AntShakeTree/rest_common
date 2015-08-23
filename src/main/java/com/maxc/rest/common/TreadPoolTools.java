package com.maxc.rest.common;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池管理工具类
 * @author ant_shake_tree
 *	TODO:未完待续
 */
public final class TreadPoolTools {
	//先写死
	private static long HEAP_M=1024*1024;
	private static long TOTAL_M =HEAP_M*2;
	private static long PERM_M =128*1024;
	
	private static long SYSTME_RETAIN_M=100*1024;
	private static long STACK_ALLOC=1*1024;
	private static int PROCESS=Runtime.getRuntime().availableProcessors();
	//短消息，需要少量就可以。甚至不需要。指的是10秒以内的运算
	private static ExecutorService shortMessageThreadPool=Executors.newFixedThreadPool(PROCESS);
	
	//临时计算最多产生的线程数。除以2 是留出足够的内存存储数据和计算
	public static int threadNums() {
		return (int) (((TOTAL_M-HEAP_M-PERM_M-SYSTME_RETAIN_M)/STACK_ALLOC)-PROCESS)/2;
	}
	//小于10秒的统一算是短消息。
	public static <V> Future<V> shortSubmit(Callable<V> task) {
		return shortMessageThreadPool.submit(task);
	}
	
	//小于10秒的统一算是短消息。
	public static  void shortExecute(Runnable command){
		shortMessageThreadPool.execute(command);
	}
	
}
