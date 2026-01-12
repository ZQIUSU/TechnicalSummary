package site.zqiusu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "accounts_receivable")
@org.hibernate.annotations.Table(appliesTo = "accounts_receivable",
        comment = "应收账款表")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountsReceivable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receivable_id", columnDefinition = "BIGINT COMMENT '应收账款ID'")
    private Long receivableId;

    @Column(name = "customer_name", nullable = false, length = 200,
            columnDefinition = "VARCHAR(200) NOT NULL COMMENT '客户名称'")
    private String customerName;

    @Column(name = "receivable_amount", nullable = false, precision = 18, scale = 2,
            columnDefinition = "DECIMAL(18,2) NOT NULL COMMENT '应收金额'")
    private BigDecimal receivableAmount;

    @Column(name = "due_date", columnDefinition = "DATE COMMENT '应收到期日'")
    private LocalDate dueDate;

    @Column(name = "overdue_days", columnDefinition = "INT COMMENT '逾期天数'")
    private Integer overdueDays;

    @Enumerated(EnumType.STRING)
    @Column(name = "collection_status", length = 20,
            columnDefinition = "VARCHAR(20) COMMENT '收款状态(pending/partially_collected/collected/overdue)'")
    private CollectionStatus collectionStatus;

    @Column(name = "aging_analysis", length = 20,
            columnDefinition = "VARCHAR(20) COMMENT '账龄分析'")
    private String agingAnalysis;

    @Column(name = "business_content", length = 500,
            columnDefinition = "VARCHAR(500) COMMENT '业务内容'")
    private String businessContent;

    @Column(name = "remark", columnDefinition = "TEXT COMMENT '备注'")
    private String remark;

    @Column(name = "created_time", updatable = false,
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private LocalDateTime createdTime;

    @Column(name = "updated_time",
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'")
    private LocalDateTime updatedTime;

    // 枚举类定义
    public enum CollectionStatus {
        PENDING("待收款"),
        PARTIALLY_COLLECTED("部分收款"),
        COLLECTED("已收款"),
        OVERDUE("逾期");

        private final String description;

        CollectionStatus(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    // 业务方法：计算逾期天数
    public void calculateOverdueDays() {
        if (dueDate != null && collectionStatus != CollectionStatus.COLLECTED) {
            LocalDate currentDate = LocalDate.now();
            if (currentDate.isAfter(dueDate)) {
                this.overdueDays = (int) ChronoUnit.DAYS.between(dueDate, currentDate);
                if (collectionStatus != CollectionStatus.OVERDUE) {
                    this.collectionStatus = CollectionStatus.OVERDUE;
                }
            } else {
                this.overdueDays = 0;
            }
        }
    }


    @Override
    public String toString() {
        return "AccountsReceivable{" +
                "receivableId=" + receivableId +
                ", customerName='" + customerName + '\'' +
                ", receivableAmount=" + receivableAmount +
                ", dueDate=" + dueDate +
                ", collectionStatus=" + collectionStatus +
                '}';
    }
}