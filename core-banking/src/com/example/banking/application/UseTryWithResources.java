package com.example.banking.application;

public class UseTryWithResources {

	public static void gun() {
		var res1 = new PreciousResource(1);
		var res2 = new PreciousResource(2);
		var res3 = new PreciousResource(3);
		try {
			throw new IllegalArgumentException("Ooopss");
		} catch (Exception e) {
			System.err.println("Have an exception in gun(): %s".formatted(e.getMessage()));
		} finally {
			try {
				res1.close();
			} catch (Exception e) {
				System.err.println("Having exception while closing the res1: %s".formatted(e.getMessage()));
			} finally {
				try {
					res2.close();
				} catch (Exception e) {
					System.err.println("Having exception while closing the res2: %s".formatted(e.getMessage()));
				} finally {
					try {
						res3.close();
					} catch (Exception e) {
						System.err.println("Having exception while closing the res3: %s".formatted(e.getMessage()));
					}
				}
			}
		}
	}

	public static void gun7() {
		try (
				var res1 = new PreciousResource(1);
				var res2 = new PreciousResource(2);
				var res3 = new PreciousResource(3);
		){
			throw new IllegalArgumentException("Ooopss");
		} 
		catch (Exception e) {
			System.err.println("Have an exception in gun(): %s".formatted(e.getMessage()));
		}
	}

	public static void main(String[] args) {
		gun();
	}

}

class PreciousResource implements AutoCloseable {
	private final int id;

	public PreciousResource(int id) {
		this.id = id;
	}

	@Override
	public void close() throws Exception {
		System.err.println("Closing the precious resource (%d)...".formatted(id));
		throw new Exception("Error has occured while closing the resource (%d)...".formatted(id));
	}

}