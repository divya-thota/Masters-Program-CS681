package edu.umb.cs681.hw4;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

	public RunnablePrimeGenerator(long from, long to) {
		super(from, to);
	}

	public void run() {
		generatePrimes();
	}

	public static void main(String[] args) {
		
		RunnablePrimeGenerator Primegen1 = new RunnablePrimeGenerator(1, 2000000);
		Thread t = new Thread(Primegen1);

		long start1 = System.currentTimeMillis();
		t.start();
		try {
			t.join();
		} 
		catch (InterruptedException e) {}
		long stop1 = System.currentTimeMillis();
		long elapsed1 = stop1 - start1;
		Primegen1.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));
		long primeNum = Primegen1.getPrimes().size();
		System.out.println("Calculating elapsed time");
		System.out.println("\nTotal " + primeNum + " prime numbers found.");
		System.out.println("1 Thread elapsed time: " + elapsed1 + " ms");

		RunnablePrimeGenerator primegen1Case2 = new RunnablePrimeGenerator(1, 1000000);
		RunnablePrimeGenerator primegen2Case2 = new RunnablePrimeGenerator(1000001, 2000000);
		Thread t1 = new Thread(primegen1Case2);
		Thread t2 = new Thread(primegen2Case2);

		long start2 = System.currentTimeMillis();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}

		long stop2 = System.currentTimeMillis();
		long elapsed2 = stop2 - start2;
		System.out.println("2 Threads elapsed time: " + elapsed2 + " ms");

		RunnablePrimeGenerator primegen1Case3 = new RunnablePrimeGenerator(1, 500000);
		RunnablePrimeGenerator primegen2Case3 = new RunnablePrimeGenerator(500001, 1000000);
		RunnablePrimeGenerator primegen3Case3 = new RunnablePrimeGenerator(1000001, 1500000);
		RunnablePrimeGenerator primegen4Case3 = new RunnablePrimeGenerator(1500001, 2000000);
		Thread t41 = new Thread(primegen1Case3);
		Thread t42 = new Thread(primegen2Case3);
		Thread t43 = new Thread(primegen3Case3);
		Thread t44 = new Thread(primegen4Case3);

		long startTimeT4 = System.currentTimeMillis();
		t41.start();
		t42.start();
		t43.start();
		t44.start();
		try {
			t41.join();
			t42.join();
			t43.join();
			t44.join();
		} catch (InterruptedException e) {
		}

		long stop4 = System.currentTimeMillis();
		long elapsedTime4 = stop4 - startTimeT4;
		System.out.println("4 Threads elapsed time: " + elapsedTime4 + " ms");

		RunnablePrimeGenerator primegen1Case4 = new RunnablePrimeGenerator(1, 250000);
		RunnablePrimeGenerator primegen2Case4 = new RunnablePrimeGenerator(250001, 500000);
		RunnablePrimeGenerator primegen3Case4 = new RunnablePrimeGenerator(500001, 750000);
		RunnablePrimeGenerator primegen4Case4 = new RunnablePrimeGenerator(750001, 1000000);
		RunnablePrimeGenerator primegen5Case4 = new RunnablePrimeGenerator(1000001, 1250000);
		RunnablePrimeGenerator primegen6Case4 = new RunnablePrimeGenerator(1250001, 1500000);
		RunnablePrimeGenerator primegen7Case4 = new RunnablePrimeGenerator(1500001, 1750000);
		RunnablePrimeGenerator primegen8Case4 = new RunnablePrimeGenerator(1750001, 2000000);
		Thread t81 = new Thread(primegen1Case4);
		Thread t82 = new Thread(primegen2Case4);
		Thread t83 = new Thread(primegen3Case4);
		Thread t84 = new Thread(primegen4Case4);
		Thread t85 = new Thread(primegen5Case4);
		Thread t86 = new Thread(primegen6Case4);
		Thread t87 = new Thread(primegen7Case4);
		Thread t88 = new Thread(primegen8Case4);

		long start8 = System.currentTimeMillis();
		t81.start();
		t82.start();
		t83.start();
		t84.start();
		t85.start();
		t86.start();
		t87.start();
		t88.start();
		try {
			t81.join();
			t82.join();
			t83.join();
			t84.join();
			t85.join();
			t86.join();
			t87.join();
			t88.join();
		} catch (InterruptedException e) {
		}

		long stop8 = System.currentTimeMillis();
		long eplapsed8 = stop8 - start8;
		System.out.println("8 Threads elapsed time: " + eplapsed8 + " ms");
		
		RunnablePrimeGenerator primegen1Case5 = new RunnablePrimeGenerator(1, 125000);
        RunnablePrimeGenerator primegen2Case5 = new RunnablePrimeGenerator(125001, 250000);
        RunnablePrimeGenerator primegen3Case5 = new RunnablePrimeGenerator(250001, 375000);
        RunnablePrimeGenerator primegen4Case5 = new RunnablePrimeGenerator(375001, 500000);
        RunnablePrimeGenerator primegen5Case5 = new RunnablePrimeGenerator(500001, 625000);
        RunnablePrimeGenerator primegen6Case5 = new RunnablePrimeGenerator(625001, 750000);
        RunnablePrimeGenerator primegen7Case5 = new RunnablePrimeGenerator(750001, 875000);
        RunnablePrimeGenerator primegen8Case5 = new RunnablePrimeGenerator(875001, 1000000);
        RunnablePrimeGenerator primegen9Case5 = new RunnablePrimeGenerator(1000001, 1125000);
        RunnablePrimeGenerator primegen10Case5 = new RunnablePrimeGenerator(1125001, 1250000);
        RunnablePrimeGenerator primegen11Case5 = new RunnablePrimeGenerator(1250001, 1375000);
        RunnablePrimeGenerator primegen12Case5 = new RunnablePrimeGenerator(1375001, 1500000);
        RunnablePrimeGenerator primegen13Case5 = new RunnablePrimeGenerator(1500001, 1625000);
        RunnablePrimeGenerator primegen14Case5 = new RunnablePrimeGenerator(1625001, 1750000);
        RunnablePrimeGenerator primegen15Case5 = new RunnablePrimeGenerator(1750001, 1875000);
        RunnablePrimeGenerator primegen16Case5 = new RunnablePrimeGenerator(1875001, 2000000);

        Thread t161 = new Thread(primegen1Case5);
        Thread t162 = new Thread(primegen2Case5);
        Thread t163 = new Thread(primegen3Case5);
        Thread t164 = new Thread(primegen4Case5);
        Thread t165 = new Thread(primegen5Case5);
        Thread t166 = new Thread(primegen6Case5);
        Thread t167 = new Thread(primegen7Case5);
        Thread t168 = new Thread(primegen8Case5);
        Thread t169 = new Thread(primegen9Case5);
        Thread t1610 = new Thread(primegen10Case5);
        Thread t1611 = new Thread(primegen11Case5);
        Thread t1612 = new Thread(primegen12Case5);
        Thread t1613 = new Thread(primegen13Case5);
        Thread t1614 = new Thread(primegen14Case5);
        Thread t1615 = new Thread(primegen15Case5);
        Thread t1616 = new Thread(primegen16Case5);
        long start16 = System.currentTimeMillis();
        t161.start();
        t162.start();
        t163.start();
        t164.start();
        t165.start();
        t166.start();
        t167.start();
        t168.start();
        t169.start();
        t1610.start();
        t1611.start();
        t1612.start();
        t1613.start();
        t1614.start();
        t1615.start();
        t1616.start();
        try {
            t161.join();
            t162.join();
            t163.join();
            t164.join();
            t165.join();
            t166.join();
            t167.join();
            t168.join();
            t169.join();
            t1610.join();
            t1611.join();
            t1612.join();
            t1613.join();
            t1614.join();
            t1615.join();
            t1616.join();
        } catch (InterruptedException e) {
        }

        long stop16 = System.currentTimeMillis();
        long elapsed16 = stop16 - start16;
        System.out.println("16 Threads elapsed time: " + elapsed16 + " ms");
	}

}