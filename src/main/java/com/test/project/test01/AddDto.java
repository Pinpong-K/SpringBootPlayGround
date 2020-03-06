package com.test.project.test01;

public class AddDto {

	 	private Double a;
	    private Double b;
	    private String result;
	    private String problem;
	    
	    
	    
		public AddDto(Double a, Double b, String result, String problem) {
			super();
			this.a = a;
			this.b = b;
			this.result = result;
			this.problem = problem;
		}
		public Double getA() {
			return a;
		}
		public void setA(Double a) {
			this.a = a;
		}
		public Double getB() {
			return b;
		}
		public void setB(Double b) {
			this.b = b;
		}
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
		public String getProblem() {
			return problem;
		}
		public void setProblem(String problem) {
			this.problem = problem;
		}
		
		public static class Builder {

	        private Double a;
	        private Double b;
	        private String result;
	        private String problem;

	        public Builder setA(Double a) {
	            this.a = a;
	            return this;
	        }

	        public Builder setB(Double b) {
	            this.b = b;
	            return this;
	        }

	        public Builder setResult(String result) {
	            this.result = result;
	            return this;
	        }

	        public Builder setProblem(String problem) {
	            this.problem = problem;
	            return this;
	        }

	        public AddDto build() {
	            return new AddDto(a,b,result,problem);
	        }
	    }
		
	    
	    
}


