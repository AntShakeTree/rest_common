package com.maxc.rest.common;


public enum HeightUnit {
	M {
		public double toCM(double d) {
			return d * 100.0;
		}

		public double toM(double d) {
			return d;
		}

		public double convert(double sourceDuration, HeightUnit sourceUnit) {
			return sourceUnit.toM(sourceDuration);
		}
	},
	CM {
		public double toCM(double d) {
			return d;
		}

		public double toM(double d) {
			return d / 100;
		}

		public double convert(double sourceDuration, HeightUnit sourceUnit) {
			return sourceUnit.toM(sourceDuration);
		}
	};

	public double toCM(double d) {
		throw new AbstractMethodError();
	}

	public double toM(double d) {
		throw new AbstractMethodError();
	}

	public double convert(double sourceDuration, HeightUnit sourceUnit) {
		throw new AbstractMethodError();
	}
}
