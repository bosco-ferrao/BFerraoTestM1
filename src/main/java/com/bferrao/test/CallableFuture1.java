package com.bferrao.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class CallableFuture1 {
	static AtomicInteger ai1 = new AtomicInteger(0);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, List<Object>> treeMap = new ConcurrentSkipListMap<String, List<Object>>();
		List<Object> arr1 = new ArrayList<Object>();
		treeMap.put(new String("a3"), arr1);
		arr1.add(new Object());
		arr1.add(new Object());

		treeMap.put(new String("a2"), arr1);

		treeMap.put(new String("a1"), arr1);

		ExecutorService service = new ScheduledThreadPoolExecutor(3);
		List<Future<String>> future1 = new CopyOnWriteArrayList<Future<String>>();

		for (Map.Entry<String, List<Object>> entry : treeMap.entrySet()) {
			Callable<String> task = new  Callable<String>() {
				@Override
				public String call() throws Exception {
					String dd1 = entry.getKey();
					List<Object> eList1 = entry.getValue();
					StringBuilder strB = new StringBuilder();
					for (Object e : eList1) {
						strB.append(dd1 + " " + ai1.getAndIncrement());
						strB.append(",");
					}
					return strB.toString();
				}
				
			};
			future1.add(service.submit(task));
		}

		for (Future<String> future2 : future1) {
			try {
				System.out.println((String) future2.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
