package de.hshannover.f4.trust.irongenlog.strategyparser;

public class Starter {

	public static void main(String[] args) throws ParseException {

		IfMapStrategyParser parser;
		try {
			parser = IfMapStrategyParser.getNewParser("/test.dom",
					"src/main/java/de/hshannover/f4/trust/irongenlog/publisher/strategies/DhcpStrategy.java");
			parser.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
