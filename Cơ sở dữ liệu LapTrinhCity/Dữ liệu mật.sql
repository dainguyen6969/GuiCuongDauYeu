CREATE DATABASE CSDL_SOF2042
GO
USE CSDL_SOF2042

CREATE TABLE Hoc_Vien(
	Ma_Hoc_Vien VARCHAR(15) PRIMARY KEY,
	Ho_Va_Ten NVARCHAR(100),
	Anh NVARCHAR,
	TrangThai NVARCHAR(50)
);
ALTER TABLE Hoc_Vien 
ALTER COLUMN Anh NVARCHAR(MAX);
GO
CREATE TABLE Giang_Vien(
	Ma_Giang_Vien VARCHAR(15) PRIMARY KEY,
	Ho_Va_Ten NVARCHAR(100),
	Bo_Mon NVARCHAR(50),
	Trang_Thai NVARCHAR(50)
);

GO
CREATE TABLE Khoa_Hoc(
	Ma_Khoa_Hoc VARCHAR(15) PRIMARY KEY,
	Ten_Khoa_Hoc NVARCHAR(100),
	Tin_Chi INT,
	Trang_Thai NVARCHAR(50)
);

GO
CREATE TABLE Chuyen_De(
	Ma_Chuyen_De VARCHAR(15) PRIMARY KEY,
	Ten_Chuyen_De NVARCHAR(100),
	Ngay_Bat_Dau DATE,
	Ngay_Ket_Thuc DATE
);

GO
CREATE TABLE Nhan_Vien(
	Ma_Nhan_Vien VARCHAR(15) PRIMARY KEY,
	Ten_Nhan_Vien NVARCHAR(100),
	Chuc_Vu NVARCHAR(50),
	Role INT,
	Trang_Thai NVARCHAR(50)
);

GO
CREATE TABLE Quan_Ly(
	Ma_Quan_Ly VARCHAR(15) PRIMARY KEY,
	Ten_Quan_Ly NVARCHAR(100),
	Role INT,
	TrangThai NVARCHAR(50)
);

GO
/*CREATE TABLE So_Lieu_Thong_Ke(

); */

CREATE TABLE Giang_Day(
	Giang_Vien_MA VARCHAR(15),
	Hoc_Vien_Ma VARCHAR(15),

	PRIMARY KEY (Giang_Vien_Ma, Hoc_Vien_Ma),
	FOREIGN KEY (Giang_Vien_Ma)REFERENCES Giang_Vien(Ma_Giang_Vien),
	FOREIGN KEY (Hoc_Vien_Ma)REFERENCES Hoc_Vien(Ma_Hoc_Vien)
);

GO
CREATE TABLE Hoc_Vien_Tham_Gia_Khoa_Hoc(
	Hoc_Vien_MA VARCHAR(15),
	Khoa_Hoc_Ma Varchar(15),
	PRIMARY KEY (Hoc_Vien_Ma, Khoa_Hoc_Ma),
	FOREIGN KEY (Hoc_Vien_Ma) REFERENCES Hoc_Vien(Ma_Hoc_Vien),
	FOREIGN KEY (Khoa_Hoc_Ma) REFERENCES Khoa_Hoc(Ma_Khoa_Hoc)

);

GO
CREATE TABLE Khoa_Hoc_Thuoc_Chuyen_De(
	Chuyen_De_Ma VARCHAR(15),
	Khoa_Hoc_Ma VARCHAR(15),
	PRIMARY KEY (Chuyen_De_Ma, Khoa_Hoc_Ma),
	FOREIGN KEY (Chuyen_De_Ma) REFERENCES Chuyen_De(Ma_Chuyen_De),
	FOREIGN KEY (Khoa_Hoc_Ma) REFERENCES Khoa_Hoc(Ma_Khoa_Hoc)
);

GO
CREATE TABLE Giao_Vien_Nhan_Vien(
	Nhan_Vien_Ma VARCHAR(15),
	Quan_Ly_Ma VARCHAR(15),
	PRIMARY KEY (Nhan_Vien_Ma, Quan_Ly_Ma),
	FOREIGN KEY (Nhan_Vien_Ma) REFERENCES Nhan_Vien(Ma_Nhan_Vien),
	FOREIGN KEY (Quan_Ly_Ma) REFERENCES Quan_Ly(Ma_Quan_Ly)
);

GO
CREATE TABLE HoTroGiangVien (
    nhan_vien_id VARCHAR(15),
    giang_vien_id VARCHAR(15),
    PRIMARY KEY (nhan_vien_id, giang_vien_id),
    FOREIGN KEY (nhan_vien_id) REFERENCES Nhan_Vien(Ma_Nhan_Vien),
    FOREIGN KEY (giang_vien_id) REFERENCES Giang_Vien(Ma_Giang_Vien)
);

INSERT INTO Hoc_Vien(Ma_Hoc_Vien, Ho_Va_Ten, Anh, TrangThai)
		VALUES('HV001', N'Nguyễn Đại Trọng', NULL, N'Đi học'),
		('HV002', N'Lê Minh Trang', NULL, N'Đi học'),
		('HV003', N'Phùng Bảo Long', NULL, N'Đi học'),
		('HV004', N'Phan Ngọc Anh', NULL, N'Đi học'),
		('HV005', N'Phan Thế Dũng', NULL, N'Đi học'),
		('HV006', N'Đào Việt Cường', NULL, N'Đi học'),
		('HV007', N'Nguyễn Minh Tiến', NULL, N'Đi học'),
		('HV008', N'Đại Trọng Nguyễn', NULL, N'Đi học'),
		('HV009', N'Trọng Nguyễn Đại', NULL, N'Đi học'),
		('HV010', N'Đại Đẹp Trai', NULL, N'Nghỉ học'),
		('HV011', N'Nguyễn Đại Trọng1', NULL, N'Bảo lưu'),
		('HV012', N'Nguyễn Đại Trọng2', NULL, N'Đi học'),
		('HV013', N'Nguyễn Đại Trọng3', NULL, N'Đi học'),
		('HV014', N'Nguyễn Đại Trọng4', NULL, N'Đi học'),
		('HV015', N'Nguyễn Đại Trọng5', NULL, N'Đi học'),
		/*('HV016', N'Nguyễn Đại Trọng6', NULL, N'Đi học'),*/
		('HV017', N'Nguyễn Đại Trọng7', NULL, N'Đi học')
SELECT * FROM Hoc_Vien ORDER BY LEN(Ma_Hoc_Vien), Ma_Hoc_Vien; /*Dùng cách này để sắp xếp theo đúng giá trị*/

INSERT INTO Giang_Vien(Ma_Giang_Vien, Ho_Va_Ten, Bo_Mon, Trang_Thai)
		VALUES('GV001', N'Trần Thị Mai Hê', N'Hệ thống thông tin', N'Đi làm'),
		('GV002', N'Bùi Văn Sơn', N'Công nghệ phần mềm', N'Đi làm'),
		('GV003', N'Phạm Giá Khánh', N'Công nghệ phần mềm', N'Đi làm'),
		('GV004', N'Phạm Văn Luân', N'Hệ thống thông tin', N'Đi làm'),
		('GV005', N'Nguyễn Thị Mai Hê', N'Khoa học máy tính', N'Làm biếng')
SELECT * FROM Giang_Vien

INSERT INTO Khoa_Hoc(Ma_Khoa_Hoc, Ten_Khoa_Hoc, Tin_Chi, Trang_Thai)
		VALUES		
		('KH001', N'Khóa học Java căn bản', '3', N'Hoạt động'),
		('KH002', N'Lập trình Python từ cơ bản đến nâng cao', '4', N'Dùng hoạt động'),
		('KH003', N'Khóa học AI & Machine Learning', '4', N'Dùng hoạt động'),
		('KH004', N'Hacker mũ trắng & An ninh mạng', '3', N'Dừng hoạt động'),
		('KH005', N'SQL', '2', N'Hoạt động'),
		('KH006', N'Thiết kế UX UI', '2', N'Hoạt động')

SELECT * FROM Khoa_Hoc

INSERT INTO Chuyen_De(Ma_Chuyen_De,Ten_Chuyen_De , Ngay_Bat_Dau, Ngay_Ket_Thuc)
		VALUES('CD001', N'Lập trình Python', '1/1/2025', '2/2/2025'),
		('CD002', N'Java 1', '1/1/2025', '2/2/2025'),
		('CD003', N'OOP', '1/1/2025', '2/2/2025'),
		('CD004', N'SQL', '1/1/2025', '2/2/2025'),
		('CD005', N'Java 2', '1/1/2025', '2/2/2025'),
		('CD006', N'Java 3', '1/1/2025', '2/2/2025'),
		('CD007', N'Lập trình Python', '1/1/2025', '2/2/2025'),
		('CD008', N'Lập trình Python', '1/1/2025', '2/2/2025'),
		('CD009', N'Lập trình Python', '1/1/2025', '2/2/2025')
SELECT * FROM Chuyen_De

INSERT INTO Nhan_Vien(Ma_Nhan_Vien, Ten_Nhan_Vien, Chuc_Vu, Role, Trang_Thai)
		VALUES('NV001', N'Đại Cô Lô Nhuê', N'Hỗ trợ giảng viên', 1, N'Đang làm'),
		('NV002', N'Cường Gió Tai', N'Lao công', 2, N'Đang làm'),
		('NV003', N'Tiến Uy Tín', N'Bảo vệ', 2, N'Đang làm')

SELECT * FROM Nhan_Vien

INSERT INTO Quan_Ly(Ma_Quan_Ly, Ten_Quan_Ly,Role,TrangThai)
		VALUES('QL001', N'Đại Ca', 3, N'Đang làm')
SELECT * FROM Quan_Ly



SELECT * FROM Hoc_Vien ORDER BY LEN(Ma_Hoc_Vien), Ma_Hoc_Vien;
SELECT * FROM Giang_Vien
SELECT * FROM Khoa_Hoc
SELECT * FROM Chuyen_De
SELECT * FROM Nhan_Vien
SELECT * FROM Quan_Ly
SELECT Ma_Nhan_Vien, Ten_Nhan_Vien, Chuc_Vu, Trang_Thai FROM Nhan_Vien

UPDATE Hoc_Vien SET Anh = 'C:\Users\ThinkPad\Downloads\z6313551177323_16de2a5bbd8390f68adcbc489e2397d5.jpg' WHERE Ma_Hoc_Vien = 'HV006'
DELETE Hoc_Vien WHERE Ma_Hoc_Vien = '';




