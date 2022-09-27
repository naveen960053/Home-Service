package com.cts.homeservice.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.homeservice.model.ConfirmBooking;
import com.cts.homeservice.model.CustomerReview;
import com.cts.homeservice.repository.ConfirmBookingRepository;
import com.cts.homeservice.repository.CustomerReviewRepository;

@Service
public class AdminManagement {

	CustomerReviewRepository customerReviewRepository;
	ConfirmBookingRepository confirmBookingRepository;

	@Autowired
	public AdminManagement(CustomerReviewRepository customerReviewRepository,
			ConfirmBookingRepository confirmBookingRepository) {
		super();
		this.customerReviewRepository = customerReviewRepository;
		this.confirmBookingRepository = confirmBookingRepository;
	}

	public void addReview(CustomerReview review, String userId) {
		review.setCustomerId(userId);
		customerReviewRepository.save(review);
	}

	public List<CustomerReview> getReview() {
		return customerReviewRepository.findAll();
	}

	public List<ConfirmBooking> getReport() {
		return confirmBookingRepository.findAll();
	}

	public void generateReview() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Customer Reviews");
		Map<Integer, Object[]> dataset = new TreeMap<>();
		List<CustomerReview> review = customerReviewRepository.findAll();
		dataset.put(0, new Object[] { "Id", "AppointmentId", "VendorId", "CustomerId", "Feedback" });
		for (int i = 0; i < review.size(); i++) {
			dataset.put((i + 1), new Object[] { review.get(i).getId(), review.get(i).getAppointmentId(),
					review.get(i).getVendorId(), review.get(i).getCustomerId(), review.get(i).getFeedback() });
		}

		Set<Integer> set = dataset.keySet();
		int rowNum = 0;
		for (Integer i : set) {
			Row row = sheet.createRow(rowNum++);

			Object[] o = dataset.get(i);

			int colNum = 0;

			for (Object o1 : o) {
				Cell cell = row.createCell(colNum++);

				if (o1 instanceof String) {
					cell.setCellValue((String) o1);
				}
				if (o1 instanceof Integer) {
					cell.setCellValue((Integer) o1);
				}
			}

		}
		try {
			FileOutputStream out = new FileOutputStream("R:/HomeService/review.xlsx");
			workbook.write(out);
			out.close();
			System.out.println("Excel file created successfully.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void generateReport() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Services Report");
		Map<Integer, Object[]> dataset = new TreeMap<>();
		List<ConfirmBooking> booking = confirmBookingRepository.findAll();
		dataset.put(0, new Object[] { "S.No", "AppointmentId", "VendorId", "Vendor Name", "Vendor Contact Info",
				"CustomerId", "Customer Name", "Customer Contact Info", "Service", "Status" });
		for (int i = 0; i < booking.size(); i++) {
			dataset.put((i + 1),
					new Object[] { i, booking.get(i).getAppointmentId(), booking.get(i).getVendorId(),
							booking.get(i).getVendorName(), booking.get(i).getVendorContactNumber(),
							booking.get(i).getCustomerId(), booking.get(i).getCustomerName(),
							booking.get(i).getVendorContactNumber(),booking.get(i).getServiceType(),booking.get(i).getStatus()});
		}

		Set<Integer> set = dataset.keySet();
		int rowNum = 0;
		for (Integer i : set) {
			Row row = sheet.createRow(rowNum++);

			Object[] o = dataset.get(i);

			int colNum = 0;

			for (Object o1 : o) {
				Cell cell = row.createCell(colNum++);

				if (o1 instanceof String) {
					cell.setCellValue((String) o1);
				}
				if (o1 instanceof Integer) {
					cell.setCellValue((Integer) o1);
				}
			}

		}
		try {
			FileOutputStream out = new FileOutputStream("R:/HomeService/report.xlsx");
			workbook.write(out);
			out.close();
			System.out.println("Excel file created successfully.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
