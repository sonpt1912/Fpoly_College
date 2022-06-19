--												ASSM 2
/*Bài 1: Triển khai 3 Store Proc cho 3 bảng sau thực hiện CRUD bảng:
Bảng Nhân Viên
Bảng Khách Hàng
Bảng Chi Tiết Sản Phẩm
Không cho phép ít nhất 4 tham số khác Null khi INSERT trên mỗi bảng khi sử dụng STORE PROC.
Ứng dụng: Sử dụng Try Catch trong mỗi bảng và in ra đầy đủ các hàm lỗi theo những cách đã được học.
Viết hoa các Varchar và Nvarchar khi truyền vào thông qua tham số một cách hợp lý. 
In ra các thông báo lỗi phù hợp trong bài.
Không truyền khoá phụ vào tham số của STORE PROC trên chỉ truyền Mã.
*/
--NHANVIEN VÀ HÀM CHECK NHÂN VIÊN
CREATE FUNCTION F_CHECK_NHANVIEN (@ID INT,
							 @Ma VARCHAR(20),
							 @Ten NVARCHAR(10),
							 @TenDem NVARCHAR(20),
							 @Ho NVARCHAR(10),
							 @GioiTinh NVARCHAR(5),
							 @NgaySinh DATE,
							 @DiaChi NVARCHAR(50),
							 @Sdt INT,
							 @TrangThai INT,
							 @MaCV VARCHAR(20),
							 @MaCH VARCHAR(20),
							 @MaBaoCao VARCHAR(20))
RETURNS INT
AS
BEGIN
		DECLARE @CHECK INT SET @CHECK = 0
		IF @ID IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @Ma IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @Ten IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @TenDem IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @Ho IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @GioiTinh IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @NgaySinh IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @DiaChi IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @Sdt IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @TrangThai IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @MaCV IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @MaCH IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @MaBaoCao IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		RETURN @CHECK
		
END
GO
CREATE PROC SP_CRUD_NHANVIEN(@ID INT,
							 @Ma VARCHAR(20),
							 @Ten NVARCHAR(10),
							 @TenDem NVARCHAR(20),
							 @Ho NVARCHAR(10),
							 @GioiTinh NVARCHAR(5),
							 @NgaySinh DATE,
							 @DiaChi NVARCHAR(50),
							 @Sdt INT,
							 @TrangThai INT,
							 @MaCV VARCHAR(20),
							 @MaCH VARCHAR(20),
							 @MaBaoCao VARCHAR(20),
							 @SqlType VARCHAR(MAX)
							)
AS
BEGIN
	IF @SqlType = 'SELECT'
	BEGIN
			SELECT * FROM NhanVien
	END
	IF @SqlType = 'INSERT'
	BEGIN
			IF dbo.F_CHECK_NHANVIEN( @ID ,@Ma, @Ten, @TenDem, @Ho, @GioiTinh,
			@NgaySinh, @DiaChi, @Sdt, @TrangThai, @MaCV, @MaCH, @MaBaoCao) >3
			BEGIN
				PRINT N'KHÔNG ĐƯỢC NHẬP NULL'
				ROLLBACK TRANSACTION

			END
			ELSE 
			BEGIN
					DECLARE @IdBaoCao INT, @IdCV INT, @IdCH INT		
					SET @IdBaoCao = (SELECT TOP 1 Id FROM NhanVien WHERE Ma = @MaBaoCao)
					SET @IdCV = (SELECT TOP 1 Id FROM ChucVu WHERE Ma =  @MaCV )
					SET @IdCH = (SELECT TOP 1 Id FROM CuaHang WHERE Ma = @MaCH)
					INSERT NhanVien VALUES (@MA, @Ten, @TenDem, @Ho, @GioiTinh, @NgaySinh, 
					@DiaChi, @Sdt,@TrangThai, @IdCV, @IdCH, @IdBaoCao )
			END
	END
	IF @SqlType = 'UPDATE'
	BEGIN
		UPDATE NhanVien SET Ma = @Ma, Ten = @Ten
		WHERE ID = @ID
	END
	IF @SqlType = 'DELETE'
	BEGIN
		DELETE FROM NhanVien WHERE Ma = @Ma
	END
END

BEGIN TRY
    EXEC SP_CRUD_NHANVIEN  @id=0,@Ma ='PH3',@Ten=NULL,@TenDem= NULL,@Ho=NULL,@GioiTinh=NULL,
                            @NgaySinh=NULL,@DiaChi=N'công viên thống nhất',@Sdt='',@MaCH='ch1',@MaCV='cv1',
							@MaBaoCao='nv1',@TrangThai= 1,@SqlType='INSERT'				
END TRY
BEGIN CATCH
	DECLARE @ERROR_SEVERTY INT, @ERROR_STATE INT, @ERROR_NUMBER INT, @ERROR_MESSAGE VARCHAR(MAX)
	SELECT
	@ERROR_NUMBER = ERROR_NUMBER(),
	@ERROR_MESSAGE = ERROR_MESSAGE(),
	@ERROR_SEVERTY = ERROR_SEVERITY(),
	@ERROR_STATE = ERROR_STATE()
	PRINT @ERROR_NUMBER 
	PRINT @ERROR_MESSAGE
	PRINT @ERROR_SEVERTY
	PRINT @ERROR_STATE
	--RAISERROR(@ERROR_SEVERTY,@ERROR_STATE)
END CATCH


------KHÁCH HÀNG
CREATE FUNCTION F_CHECK_KHACHHANG (@ID INT,
								@Ma VARCHAR(20),
								@Ten NVARCHAR(10),
								@TenDem NVARCHAR(20),
								@Ho NVARCHAR(10),		
								@NgaySinh DATE,
								@DiaChi NVARCHAR(50),
								@Sdt INT,
								@ThanhPho NVARCHAR(20),
								@QuocGia NVARCHAR(20))
RETURNS INT
AS
BEGIN
		DECLARE @CHECK INT SET @CHECK = 0
		IF @ID IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @Ma IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @Ten IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @TenDem IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @Ho IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @NgaySinh IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @DiaChi IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @Sdt IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @ThanhPho IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @QuocGia IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		RETURN @CHECK
		
END
GO
CREATE PROC SP_CRUD_KHACHHANG (@ID INT,
							 @Ma VARCHAR(20),
							 @Ten NVARCHAR(10),
							 @TenDem NVARCHAR(20),
							 @Ho NVARCHAR(10),		
							 @NgaySinh DATE,
							 @DiaChi NVARCHAR(50),
							 @Sdt INT,
						     @ThanhPho NVARCHAR(20),
							 @QuocGia NVARCHAR(20),
							 @SqlType VARCHAR(MAX)
							)
AS
BEGIN
	IF @SqlType = 'SELECT'
	BEGIN
			SELECT * FROM KhachHang
	END
	IF @SqlType = 'INSERT'
	BEGIN
			IF dbo.F_CHECK_KHACHHANG (@ID, @Ma, @Ten, @TenDem,
			   @Ho, @NgaySinh, @DiaChi, @Sdt,
			   @ThanhPho, @QuocGia) > 3
			BEGIN
				PRINT N'KHÔNG ĐƯỢC NHẬP NULL'
				ROLLBACK TRANSACTION

			END
			ELSE 
			BEGIN
					INSERT KhachHang VALUES
					( @Ma, @Ten , @TenDem,
				     @Ho, @NgaySinh, @DiaChi, @Sdt,
				     @ThanhPho, @QuocGia )
			END
	END
	IF @SqlType = 'UPDATE'
	BEGIN
		UPDATE KhachHang SET Ma = @Ma, Ten = @Ten
		WHERE ID = @ID
	END
	IF @SqlType = 'DELETE'
	BEGIN
		DELETE FROM KhachHang WHERE Ma = @Ma
	END
END

BEGIN TRY
    EXEC SP_CRUD_KHACHHANG @id=0,@Ma =null,@Ten='duy',@TenDem='tran',@Ho='duc',
                            @NgaySinh='2003-12-12',@DiaChi=N'công viên thống nhất',@Sdt='',
							@ThanhPho = N'HÒA BÌNH', @QuocGia = N'VIỆT NAM' ,@TrangThai= 1,@SqlType='INSERT'
END TRY
BEGIN CATCH
	DECLARE @ERROR_SEVERTY INT, @ERROR_STATE INT, @ERROR_NUMBER INT, @ERROR_MESSAGE VARCHAR(MAX)
	SELECT
	@ERROR_NUMBER = ERROR_NUMBER(),
	@ERROR_MESSAGE = ERROR_MESSAGE(),
	@ERROR_SEVERTY = ERROR_SEVERITY(),
	@ERROR_STATE = ERROR_STATE()
	PRINT @ERROR_NUMBER 
	PRINT @ERROR_MESSAGE
	PRINT @ERROR_SEVERTY
	PRINT @ERROR_STATE
	--RAISERROR(@ERROR_SEVERTY,@ERROR_STATE)
END CATCH


--SELECT * FROM ChiTietSP
---- CHI THIẾT SẢN PHẨM
GO
CREATE FUNCTION F_CHECK_CTSP (@ID INT,
							   @MaSP VARCHAR(20),
							   @MaMX VARCHAR(30),
							   @MaDSP VARCHAR(30),
							   @NamBH INT,
							   @MoTa NVARCHAR(100),
							   @SoLuongTon INT,
							   @GiaNhap MONEY,
							   @GiaBan MONEY
							)
							 
RETURNS INT
AS
BEGIN
		DECLARE @CHECK INT SET @CHECK = 0
		IF @ID IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @MaSP IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @MaMX IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @MaDSP IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @SoLuongTon IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @GiaNhap IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @NamBH IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @MoTa IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		IF @GiaBan IS NULL
		BEGIN
			SET	@CHECK += 1;
		END
		RETURN @CHECK
		
END
GO
CREATE PROC SP_CRUD_CTSANPHAM (@ID INT,
							   @MaSP VARCHAR(20),
							   @MaMX VARCHAR(30),
							   @MaDSP VARCHAR(30),
							   @NamBH INT,
							   @MoTa NVARCHAR(100),
							   @SoLuongTon INT,
							   @GiaNhap MONEY,
							   @GiaBan MONEY,
							   @SqlType VARCHAR(20)
							)
AS
BEGIN
	IF @SqlType = 'SELECT'
	BEGIN
			SELECT * FROM ChiTietSP
	END
	IF @SqlType = 'INSERT'
	BEGIN
			IF dbo.F_CHECK_CTSP(@ID, @MaSP, @MaMX, @MaDSP,@NamBH, @MoTa, @SoLuongTon, @GiaNhap, @GiaBan) > 3
			BEGIN
				PRINT N'KHÔNG ĐƯỢC NHẬP NULL'
				ROLLBACK TRANSACTION

			END
			ELSE 
			BEGIN
					DECLARE  @IdMX INT, @IdDSP INT		
					SET @IdDSP = (SELECT TOP 1 Id FROM DongSP WHERE Ma = @MaDSP)
					SET @IdMX = (SELECT TOP 1 Id FROM MauSac WHERE Ma =  @MaMX )
					INSERT ChiTietSP VALUES (@MaSP,@IdMX, @IdDSP, @NamBH, @MoTa,@SoLuongTon,@GiaNhap, @GiaBan)
			END
	END
	IF @SqlType = 'UPDATE'
	BEGIN
		UPDATE ChiTietSP SET SoLuongTon = @SoLuongTon, GiaBan = @GiaBan
		WHERE ID = @ID
	END
	IF @SqlType = 'DELETE'
	BEGIN
		DELETE FROM ChiTietSP WHERE ID = @ID
	END
END

BEGIN TRY
    EXEC SP_CRUD_CTSANPHAM @Id = 0,@MaSP = 'PH1',@MaMX = 'MX1', @MaDSP = 'TT1', @NamBH = NULL,
							 @MoTa = N'ĐIỆN THOẠI', @SoLuongTon = NULL, @GiaNhap = NULL, @GiaBan = NULL, @SqlType = 'SELECT'
END TRY
BEGIN CATCH
	DECLARE @ERROR_SEVERTY INT, @ERROR_STATE INT, @ERROR_NUMBER INT, @ERROR_MESSAGE VARCHAR(MAX)
	SELECT
	@ERROR_NUMBER = ERROR_NUMBER(),
	@ERROR_MESSAGE = ERROR_MESSAGE(),
	@ERROR_SEVERTY = ERROR_SEVERITY(),
	@ERROR_STATE = ERROR_STATE()
	PRINT @ERROR_NUMBER 
	PRINT @ERROR_MESSAGE
	PRINT @ERROR_SEVERTY
	PRINT @ERROR_STATE
	RAISERROR(@ERROR_SEVERTY,@ERROR_STATE)
END CATCH




--/*Bài 2: Trigger
--TD1 Tạo 1 Trigger Insert & Update cho bảng chi tiết sản phẩm số lượng tồn không được < 0, Giá Nhập  < 50000
--và Năm Bảo hành phải lớn hơn năm hiện tại.
--TD2 Tạo 1 Trigger Delete cho bảng nhân viên cho phép xóa nhân viên kể cả khi nhân viên đó đang có liên kết khóa phụ với bảng khác.
--*/
---- TD1
GO 
CREATE TRIGGER TG_TD1_INSERT ON ChiTietSP
FOR INSERT
AS
BEGIN
		DECLARE @CHECK DATE SET @CHECK= ( SELECT NgayNhan FROM HoaDon)
		IF ((SELECT SoLuongTon FROM inserted) < 0) OR ((SELECT GiaNhap FROM inserted) < 50000) OR 
		( @CHECK + (SELECT NamBH FROM inserted) > YEAR(GETDATE()))
		BEGIN
				PRINT N'KHÔNG THỂ INSERT SỐ LƯỢNG TỒN KHO KHÔNG THẾ < 0 VÀ GIÁ NHẬP < 5000'
				ROLLBACK TRANSACTION 
		END
END

SELECT* FROM HoaDon
GO 
CREATE TRIGGER TG_TD1_UPDATE ON ChiTietSP
FOR UPDATE
AS
BEGIN
		DECLARE @CHECK DATE SET @CHECK= ( SELECT NgayNhan FROM HoaDon)
		IF ((SELECT SoLuongTon FROM inserted) < 0) OR ((SELECT GiaNhap FROM inserted) < 50000) OR 
		( @CHECK + (SELECT NamBH FROM inserted) > YEAR(GETDATE()))
		BEGIN
				PRINT N'KHÔNG THỂ INSERT SỐ LƯỢNG TỒN KHO KHÔNG THẾ < 0 VÀ GIÁ NHẬP < 5000'
				ROLLBACK TRANSACTION 
		END
END
-- TRIGGER XÓA
SELECT* FROM NhanVien
GO 
CREATE TRIGGER TG_TD2_DELETE ON NhanVien
INSTEAD OF DELETE
AS
BEGIN
		IF (SELECT IdCV FROM NhanVien) IN (SELECT Id FROM ChucVu)
		BEGIN
				DELETE FROM ChucVu WHERE Id IN(SELECT Id FROM deleted)
		END
		IF (SELECT IdCH FROM NhanVien) IN (SELECT Id FROM CuaHang)
		BEGIN
			DELETE FROM CuaHang WHERE Id IN(SELECT Id FROM deleted)
		END
		BEGIN
		DELETE FROM NhanVien WHERE Id IN(SELECT Id FROM deleted)
		END
END
DELETE FROM NhanVien WHERE Id = 1

/*Bài 3: Func

Hàm 1 tính tuổi:
Viết hàm tính tuổi tuyệt đối với tham số đầu vào là date. Hãy viết hàm tính tuổi như ví dụ dưới đây:
Ngày Hiện Tại: 28/06/2020 trừ đi 03/011/1989 = 30 tuổi
Ngày Hiện Tại: 03/11/2020 trừ đi 03/011/1989 = 31 tuổi
Viết hàm tính số lượng nhân viên theo giới tính là tham số truyền vào của hàm.
Kết quả hàm trả ra số lượng nhân viên tương ứng với giới tính đó.
In kết quả ra màn hình như sau:
“Tổng số lượng nhân viên xxx +  số lượng nhân viên theo hàm ở trên đã viết ra.”
Viết hàm tính tổng doanh thu của một sản phẩm trong khoảng thời gian chỉ định.
Tham số đầu vào của hàm sẽ bao gồm Mã SP, Ngày Bắt Đầu, Ngày Kết Thúc. Check lỗi khi nhập vào phải đảm bảo mã sản phẩm có tồn tại trong cơ sở dữ liệu,
nếu không có phải in ra lỗi không tìm thấy mã sản phẩm này.
In kết quả ra màn hình: Mã Sản Phẩm: , Tên Sản Phẩm: , Tổng số lượng bán ra: , Tổng Tiền Nhập Hàng. 
*/

-- TÍNH TUỔI
GO
CREATE FUNCTION F_TINHTUOI(@TUOI DATE)
RETURNS INT
AS
BEGIN
		DECLARE @TINH_TUOI INT
		SET @TINH_TUOI = DATEDIFF(DAYOFYEAR,@TUOI,GETDATE())
		RETURN @TINH_TUOI / 365
END
PRINT dbo.F_TINHTUOI('2003-12-19')

-- TÍNH SỐ LƯỢNG NHÂN VIÊN
GO
CREATE FUNCTION F_TINHNHANVIEN(@KIEM_TRA NVARCHAR(10))
RETURNS INT 
AS
BEGIN
		RETURN (SELECT COUNT(Ma) FROM NhanVien WHERE GioiTinh = @KIEM_TRA)
END
   DECLARE @BIEN NVARCHAR(10)
   SET @BIEN = N'NAM'
PRINT N'TỔNG SỐ NHÂN VIÊN ' + @BIEN + N' LÀ ' + CONVERT(VARCHAR(100),dbo.F_TINHNHANVIEN(@BIEN))




--TÍNH DOANH THU TRONG 1 KHOẢNG THỜI GIAN NHẤT ĐỊNH
--Viết hàm tính tổng doanh thu của một sản phẩm trong khoảng thời gian chỉ định.
GO
CREATE FUNCTION F_TinhDoanhThu(@MaSP VARCHAR(20),
							   @NgayBatDau DATE,
							   @NgayKetThuc DATE)
RETURNS MONEY
AS
BEGIN
		
				DECLARE @TIEN MONEY SET @TIEN  = (SELECT TOP 1 HoaDonChiTiet.DonGia FROM HoaDon INNER JOIN
				HoaDonChiTiet ON HoaDon.Id=HoaDonChiTiet.IdHoaDon INNER JOIN ChiTietSP ON ChiTietSP.Id=HoaDonChiTiet.IdChiTietSP
				INNER JOIN SanPham ON SanPham.Id=ChiTietSP.IdSP
				                  WHERE HoaDon.NgayTao >= @NgayBatDau AND HoaDon.NgayThanhToan <= @NgayKetThuc AND SanPham.Ma = @MaSP)
		        DECLARE @SoLuong INT SET @SoLuong  = (SELECT TOP 1 HoaDonChiTiet.SoLuong FROM HoaDon INNER JOIN
				HoaDonChiTiet ON HoaDon.Id=HoaDonChiTiet.IdHoaDon INNER JOIN ChiTietSP ON ChiTietSP.Id=HoaDonChiTiet.IdChiTietSP
				INNER JOIN SanPham ON SanPham.Id=ChiTietSP.IdSP
				                  WHERE HoaDon.NgayTao >= @NgayBatDau AND HoaDon.NgayThanhToan <= @NgayKetThuc AND SANPHAM.Ma = @MaSP)
								  DECLARE @TONG MONEY SET @TONG = @TIEN * @SoLuong
								  RETURN  @TONG
END
DECLARE @MaSP VARCHAR(MAX) SET @MaSP= 'S2'
		IF @MaSP NOT IN (SELECT Ma FROM SanPham WHERE Ma = @MaSP)
		BEGIN
				PRINT N'MÃ KHÔNG TỒN TẠI TRONG DATABASE'
				
		END
		ELSE
		BEGIN
				DECLARE @NgayBatDau DATE SET @NgayBatDau= '2000-07-11'
				DECLARE @NgayKetThuc DATE SET @NgayKetThuc= '2025-07-12'
				PRINT dbo.F_TinhDoanhThu(@MaSP,@NgayBatDau, @NgayKetThuc)
		END
/*View1 giúp quản lý các khách hàng thân thiết đối với cửa hàng như sau:
[MaKhachHanh][Họ Tên Đầy Đủ Khách Hàng] [Ngày Sinh][Số Điện Thoại][Địa Chỉ]
[Thành Phố] [Số Lượng Hàng Đã Đặt Hàng][Tổng Tiền Đã Chi Tiêu]

View2 giúp chủ cửa hàng quản lý nhân viên:
[MaNhanVien][Họ Tên Đầy Đủ Nhân Viên] [Ngày Sinh][Số Tuổi của nhân viên sử dụng hàm tính tuổi ở trên]
[Số Điện Thoại][Địa Chỉ][Giới Tính] [Tên Chức Vụ] [Số lượng sản phẩm đã bán][Số tiền hàng đã bán]


--View3 báo cáo tình trạng các hóa đơn còn chậm chưa giao cho khách và hiển thị ra cột số ngày chậm so với ngày dự kiến và gồm các cột sau:
[ID Hóa Đơn] [Mã Nhân Viên] [Tên Nhân Viên] [Ngày Lập Hóa Đơn] [Ngày Giao Hàng] [Số Ngày Chậm] [Tên Khách Hàng] [Số ĐT Khách Hàng][Tên Cửa Hàng]
*/
--VIEW 1
GO
ALTER VIEW V_KHACH_THAN 
AS 
SELECT TOP 1 KhachHang.Ma ,(KhachHang.Ho + ' ' + KhachHang.TenDem + ' ' +KhachHang.Ten ) AS 'TÊN KHÁCH HÀNG',
		KhachHang.NgaySinh, KhachHang.Sdt, KhachHang.DiaChi, KhachHang.ThanhPho,
		SUM(HoaDonChiTiet.SoLuong) AS N'SỐ LƯỢNG ĐẶT HÀNG', SUM(HoaDonChiTiet.SoLuong * HoaDonChiTiet.DonGia) AS N'TỔNG ĐÃ CHI'
FROM KhachHang INNER JOIN HoaDon ON KhachHang.Id = HoaDon.IdKH
			INNER JOIN HoaDonChiTiet ON HoaDonChiTiet.IdHoaDon = HoaDon.Id
GROUP BY KhachHang.Ma ,KhachHang.Ho, KhachHang.TenDem, KhachHang.Ten,
		KhachHang.NgaySinh, KhachHang.Sdt, KhachHang.DiaChi, KhachHang.ThanhPho
ORDER BY KhachHang.Sdt 

--VIEW 2
GO
CREATE VIEW V_QUANLY_NV
AS
SELECT DISTINCT  NhanVien.Ma, (NhanVien.Ho + ' ' + NhanVien.TenDem + ' ' +NhanVien.Ten ) AS 'TÊN NHÂN VIÊN',
		NhanVien.NgaySinh, dbo.F_TINHTUOI(NhanVien.NgaySinh) AS N'TUỔI', NhanVien.Sdt, NhanVien.DiaChi,
		NhanVien.GioiTinh, ChucVu.Ten, SUM(HoaDonChiTiet.SoLuong) AS N'TỔNG SỐ LƯỢNG ĐÃ BÁN',  
		SUM(HoaDonChiTiet.SoLuong * HoaDonChiTiet.DonGia) AS N'TỔNG TIỀN ĐÃ BÁN'
FROM NhanVien INNER JOIN ChucVu ON ChucVu.Id=NhanVien.IdCV
		 INNER JOIN HoaDon ON NhanVien.Id=HoaDon.IdNV 
		 INNER JOIN HoaDonChiTiet ON HoaDonChiTiet.IdHoaDon=HoaDon.Id
GROUP BY NhanVien.Ma, NhanVien.Ho, NhanVien.TenDem ,NhanVien.Ten,
		NhanVien.NgaySinh, NhanVien.Sdt, NhanVien.DiaChi,
		NhanVien.GioiTinh, ChucVu.Ten

-- VIEW 3
GO
CREATE VIEW V_BAOCAO
AS
SELECT DISTINCT HoaDon.ID , NhanVien.Ma, NhanVien.Ten AS N'TÊN NHÂN VIÊN', HoaDon.NgayTao, HoaDon.NgayShip,
       DATEDIFF(DAY,HoaDon.NgayNhan, HoaDon.NgayTao) AS N'SỐ NGÀY GIAO TRẬM',
	   KhachHang.Ten AS N'TÊN KHÁCH HÀNG', KhachHang.Sdt, CuaHang.Ten AS N'TÊN CỬA HÀNG'
FROM NhanVien INNER JOIN HoaDon ON HoaDon.IdNV=NhanVien.Id
	 INNER JOIN KhachHang ON KhachHang.Id=HoaDon.IdKH
	 INNER JOIN CuaHang ON CuaHang.Id=NhanVien.IdCH
GROUP BY HoaDon.ID , NhanVien.Ma, NhanVien.Ten, HoaDon.NgayTao, HoaDon.NgayShip,
	   KhachHang.Ten, KhachHang.Sdt, CuaHang.Ten,HoaDon.NgayNhan,HoaDon.NgayTao
	   SELECT * FROM V_BAOCAO

/*Công ty quyết định khen thưởng cho tất cả các nhân viên bán được từ 3 sản phẩm
trở lên sẽ tăng lương thêm 1.000.000 -
Sử dụng câu lệnh cập nhật để cập nhật lại tên tất cả nhân viên đó thêm 3tr. Ví dụ: An + 3tr
*/
UPDATE  NhanVien SET Ten = Ten + '3tr'
	WHERE Id IN (SELECT  NhanVien.Id, SUM(HoaDonChiTiet.SoLuong)
FROM NhanVien INNER JOIN HoaDon ON NhanVien.Id=HoaDon.IdNV
	 INNER JOIN HoaDonChiTiet ON HoaDon.Id=HoaDonChiTiet.IdHoaDon
GROUP BY NhanVien.Ho, NhanVien.TenDem, NhanVien.Ten
HAVING SUM(HoaDonChiTiet.SoLuong) > 3)