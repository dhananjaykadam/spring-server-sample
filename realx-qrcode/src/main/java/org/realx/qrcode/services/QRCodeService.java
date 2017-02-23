package org.realx.qrcode.services;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.realx.qrcode.enums.ImageFormat;
import org.realx.qrcode.output.size.QRImageSize;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@Service
public class QRCodeService {
	private static final String QR_CHARSET = "UTF-8";

	public OutputStream writeQRToOutputStream(final String data, QRImageSize qrImageSize, ImageFormat imageFormat)
			throws WriterException, IOException {
		Map<EncodeHintType, Object> hintMap = new HashMap<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		return writeMatrixToOutputStream(data, qrImageSize, hintMap, imageFormat, outputStream);
	}

	public OutputStream writeQRToOutputStream(final String data, QRImageSize qrImageSize, ImageFormat imageFormat,
			OutputStream outputStream) throws WriterException, IOException {
		Map<EncodeHintType, Object> hintMap = new HashMap<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		return writeMatrixToOutputStream(data, qrImageSize, hintMap, imageFormat, outputStream);
	}

	private OutputStream writeMatrixToOutputStream(final String qrCodeData, QRImageSize qrImageSize,
			Map<EncodeHintType, ?> hintMap, ImageFormat imageFormat, OutputStream outputStream)
			throws WriterException, IOException {
		BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(QR_CHARSET), QR_CHARSET),
				BarcodeFormat.QR_CODE, qrImageSize.getWidth(), qrImageSize.getHeight(), hintMap);
		MatrixToImageWriter.writeToStream(matrix, imageFormat.getFormat(), outputStream);
		return outputStream;
	}

	public static String readQRCodeFromInputStream(InputStream inputStream)
			throws FileNotFoundException, IOException, NotFoundException {
		BinaryBitmap binaryBitmap = new BinaryBitmap(
				new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(inputStream))));
		Map<DecodeHintType, Object> hintMap = new HashMap<>();
		Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap, hintMap);
		return qrCodeResult.getText();
	}
}
