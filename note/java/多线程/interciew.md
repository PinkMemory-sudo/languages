synchronized与lock的区别，使用场景。看过synchronized的源码没

Java锁有哪些种类，以及区别

- 如何保证内存可见性
- Http请求的过程与原理
- TCP连接的特点
- TCP连接如何保证安全可靠的
- 为什么TCP连接需要三次握手，两次不可以吗，为什么
- AOP的原理
- 动态代理与cglib实现的区别（这个，醉得很厉害）
- 代理的实现原理
- Ioc容器的加载过程
- 字节码的编译过程
- 项目采用了什么架构，数据库如何设计的
- 数据库由哪些表，为什么有这些表
- 主要有哪些核心模块，模块之间如何通信的
- 如何保存会话状态，有哪些方式、区别如何
- 分布式session如何管理，你有哪些方案
- 说说二分搜索的过程
- 说一下快排的过程，写一下伪代码
- 了解哪设计模式，举例说说在jdk源码哪些用到了你说的设计模式
- 每天有那么多人使用支付宝，这些数据如果给你存储，你会怎么设计呢
- 你身边同学如何评价你、老师呢































synchronized与lock的区别，使用场景。看过synchronized的源码没

lock需要手动释放锁

synchronized，代码执行完成后自动释放锁

synchronized非公平锁 			ReentrantLock都可以，默认非公平锁





```java
/*
* 题目多线程间顺序调用   实现A->B->C
* AA打印5次，BB打印10次，CC打印15次
* 接着
* AA打印5次，BB打印10次，CC打印15次
* .........
* 来十轮
* 
* */


class ShareResource{
	
	private int number =1;
	
	private Lock lock =new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();
	
	public void print5() {
		
		 lock.lock();
	        try {
	            //判断
	            while (number != 1){

	                c1.await();
	            }
	            //2 干活
	            for (int i = 1; i < 5; i++) {
					
	            	System.out.println(Thread.currentThread().getName()+"\t"+i);
				}

	            //3 通知
	            number = 2;
	            c2.signal();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally {
	        	lock.unlock();
	        }
	}
	
	public void print10() {
		
		 lock.lock();
	        try {
	            //1 判断
	            while (number != 2){

	                c2.await();
	            }
	            //2 干活
	            for (int i = 1; i < 10; i++) {
					
	            	System.out.println(Thread.currentThread().getName()+"\t"+i);
				}

	            //3 通知
	            number = 3;
	            c3.signal();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally {
	        	lock.unlock();
	        }
	}
	
	
	
	public void print15() {
		
		 lock.lock();
	        try {
	            //判断
	            while (number != 3){

	                c3.await();
	            }
	            //2 干活
	            for (int i = 1; i < 15; i++) {
					
	            	System.out.println(Thread.currentThread().getName()+"\t"+i);
				}

	            //3通知
	            number = 1;
	            c1.signal();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally {
	        	lock.unlock();
	        }
	}
	
}


public class SyncAndReentrantLockDemo {
	
	public static void main(String[] args) {
		
	ShareResource shareResource = new ShareResource();
	
	new Thread( ()->  {
		for (int i = 1; i <= 10; i++) {
			
			try {
				shareResource.print5();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	},"AA").start();

	
	new Thread( ()->  {
		for (int i = 1; i <= 10; i++) {
			
			try {
				shareResource.print10();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	},"BB").start();

	
	new Thread( ()->  {
	
		for (int i = 1; i <= 10; i++) {
			
			try {
				shareResource.print15();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	},"CC").start();

	}
}

```

