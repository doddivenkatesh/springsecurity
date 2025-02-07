package com.springsecurity.springsecurity.document.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class XLSDocumentWriter<T> {
	/*
	private final PluginRegistry<XlsCellValueStrategyService, XLSCellDataType> cellStrategyPluginRegistry;

	void write(List<T> data, String sheetName, Class<T> clazz, HttpServletResponse response) {

		response.setContentType("application/vnd.ms-excel");
		response.setStatus(OK.value());
		response.setHeader(CONTENT_DISPOSITION, "attachment;filename=" + sheetName + ".xlsx");

		if (isEmpty(data)) {
			throw new DocumentServiceException("No data to generate document");
		}

		Field[] fields = getSortedFields(clazz);
		try (var workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet(sheetName);
			createHeaderRow(sheet, fields);
			createDataRows(sheet, data, fields, workbook);
			workbook.write(response.getOutputStream());
		}
		catch (IOException | IllegalAccessException e) {
			throw new DocumentServiceException(e.getMessage());
		}
	}

	private void createHeaderRow(Sheet sheet, Field[] fields) {
		Row headerRow = sheet.createRow(0);
		for (Field field : fields) {
			if (field.isAnnotationPresent(XLSColumn.class)) {
				XLSColumn column = field.getAnnotation(XLSColumn.class);
				headerRow.createCell(column.columnIndex()).setCellValue(column.headerName());
			}
		}
	}

	private void createDataRows(Sheet sheet, List<T> data, Field[] fields, Workbook workbook)
			throws IllegalAccessException {
		int rowIndex = 1;
		for (T item : data) {
			Row row = sheet.createRow(rowIndex++);
			for (Field field : fields) {
				ReflectionUtils.makeAccessible(field);
				Object value = field.get(item);

				XLSColumn column = field.getAnnotation(XLSColumn.class);
				Cell cell = row.createCell(column.columnIndex());
				setCellValue(cell, field, value, column, workbook);
			}
		}
	}

	private Field[] getSortedFields(Class<?> clazz) {
		return Arrays.stream(clazz.getDeclaredFields()).filter(field -> field.isAnnotationPresent(XLSColumn.class))
				.sorted(Comparator.comparing(field -> field.getAnnotation(XLSColumn.class).columnIndex()))
				.toArray(Field[]::new);
	}

	private void setCellValue(Cell cell, Field field, Object value, XLSColumn column, Workbook workbook) {
		if (value == null) {
			cell.setCellValue("");
			return;
		}
		XLSCellDataType xlsCellDataType = XLSCellDataType.fromValue(field.getType().getSimpleName());
		Optional<XlsCellValueStrategyService> cellValueStrategyService = cellStrategyPluginRegistry
				.getPluginFor(xlsCellDataType);
		cellValueStrategyService.ifPresent(i -> i.setCellValue(cell, value, column, workbook));
	}*/
}
