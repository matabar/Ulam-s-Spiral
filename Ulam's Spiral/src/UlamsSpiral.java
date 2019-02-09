import java.awt.*;
import javax.swing.*;

public class UlamsSpiral {

	public static final int DIM = 700;

	public static void main(String[] args) {
		new UlamsSpiral();
	}

	public UlamsSpiral() {
		JFrame frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(new PaintPane());
		frame.setSize(DIM, DIM);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	protected class PaintPane extends JPanel {
		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {

			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			double angle = 0.0;
			int x = 100, y = 100, dx = 1, dy = 0;
			int dim = 180;
			for (int i = 1, step = 1, turn = 1; i < (dim * dim + 1); i++) {
				if (isPrime((long) i))
					g2d.fillRect(x + dim, y + dim, 2, 2);

				x += dx * 3;
				y += dy * 3;

				if (i == turn) {

					angle += 90.0;

					if ((dx == 0 && dy == -1) || (dx == 0 && dy == 1))
						step++;

					turn += step;

					dx = (int) Math.cos(Math.toRadians(angle));
					dy = (int) Math.sin(Math.toRadians(-angle));
				}
			}

		}

		public boolean isPrime(long n) {
			if (n < 2)
				return false;
			if (n == 2 || n == 3)
				return true;
			if (n % 2 == 0 || n % 3 == 0)
				return false;
			long sqrtN = (long) Math.sqrt(n) + 1;
			for (long i = 6L; i <= sqrtN; i += 6) {
				if (n % (i - 1) == 0 || n % (i + 1) == 0)
					return false;
			}
			return true;
		}
	}

}