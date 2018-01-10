//Designed By Aaron Healy - G00333148
package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	private BlockingQueue<Shingle> queue;
	private int k;
	private int [] minHashes;
	
	Map <Integer,List<Integer>> map;	
	
	//Run Method
	public void run() {
		int docCount = 1;
		int max = Integer.MAX_VALUE;
		int value = 0;
		
		while(docCount>0) {
			try {		
				Shingle s = queue.take();
				
				//If EOF been encountered in queue
				if(s.getHashCode() == 0) {
					docCount--;
					continue;
				}//if

				List<Integer> list = map.get(s.getDocID());
				
				if(list == null) {
					list = new ArrayList<Integer>(k);
					
					for(int j = 0; j <k;j++) {
						list.add(j, max);
					}//for
					
					map.put(s.getDocID(), list);	
				}//if

				for(int i = 0;i<minHashes.length;i++) {
					
					value = s.getHashCode() ^ minHashes[i];
					if(list.get(i) > value) {
						list.set(i, value);
					}//if
				}//for	
			}//try
			 catch (InterruptedException e) {
				e.printStackTrace();
			}//catch
		}//while
	}//run
	
	public Consumer(BlockingQueue<Shingle> q, Map <Integer,List<Integer>> map,int k,int[] hashes) {
		super();
		this.queue = q;
		this.k = k;
		this.map = map;
		this.minHashes = hashes;
	}//consumer
}//Consumer