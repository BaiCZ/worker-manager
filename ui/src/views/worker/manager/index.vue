<template>
  <div class="app-container">
    <!-- 查询 添加 导出 -->
    <div class="header">
      <el-input v-model="searchInfo.empName" placeholder="姓名" style="width: 220px;" />
      <el-select v-model="searchInfo.deptName">
        <el-option
          v-for="item in departmentOptions"
          :key="item.value"
          :label="item.label"
          :value="item.label"
        />
      </el-select>
      <el-select v-model="searchInfo.empDegreeName">
        <el-option
          v-for="item in educationOptions"
          :key="item.value"
          :label="item.label"
          :value="item.label"
        />
      </el-select>
      <el-button type="primary" icon="el-icon-search" @click="search">搜索</el-button>
      <el-button type="primary" icon="el-icon-edit" @click="addEmp">添加</el-button>
      <el-button :loading="downloadLoading" type="primary" icon="el-icon-download" @click="handleDownload">导出</el-button>
    </div>
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column label="序号" prop="empId" align="center" />
      <el-table-column label="职工姓名" prop="empName" align="center" />
      <el-table-column label="性别" prop="sex" :formatter="getSex" align="center" />
      <el-table-column label="年龄" prop="age" align="center" />
      <el-table-column label="部门" prop="deptName" align="center" />
      <el-table-column label="学历" prop="empDegreeName" align="center" />
      <el-table-column label="操作" align="center">
        <!-- eslint-disable-next-line -->
          <template slot-scope="scope">
          <el-button type="primary" @click="editEmp(scope.row)">编辑</el-button>
          <el-button type="danger" @click="deleteRow(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      :current-page="currentPage"
      :page-sizes="[10, 20, 30, 40]"
      :page-size="10"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />

    <!-- 职工添加编辑弹框 -->
    <el-dialog
      :title="dialogTitle"
      :visible.sync="dialogVisible"
      width="27%"
      :before-close="handleClose"
    >
      <el-form ref="form" :rules="rules" :model="formMsg" label-width="150px">
        <el-form-item label="姓名" prop="empName">
          <el-input v-model="formMsg.empName" style="width: 203px;" />
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-select v-model="formMsg.sex">
            <el-option
              v-for="item in sexOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="formMsg.age" type="number" style="width: 203px;" />
        </el-form-item>
        <el-form-item label="部门" prop="deptName">
          <el-select v-model="formMsg.deptName">
            <el-option
              v-for="item in departmentOptions"
              :key="item.value"
              :label="item.label"
              :value="item.label"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="学历" prop="empDegreeName">
          <el-select v-model="formMsg.empDegreeName">
            <el-option
              v-for="item in educationOptions"
              :key="item.value"
              :label="item.label"
              :value="item.label"
            />
          </el-select>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancel('form')">取 消</el-button>
        <el-button type="primary" @click="submitForm('form')">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { getList, deleteEmp, addMsg, editMsg } from '@/api/worker'

export default {
  data() {
    return {
      list: null,
      listLoading: true,
      currentPage: 1,
      size: 10,
      total: 0,
      sexOptions: [{
        value: 0,
        label: '男'
      }, {
        value: 1,
        label: '女'
      }],
      departmentOptions: [{ // 部门选择框
        value: '1',
        label: '业务部'
      }, {
        value: '2',
        label: '后勤部'
      }, {
        value: '3',
        label: '人事部'
      }],
      searchInfo: {
        empName: null,
        deptName: null,
        empDegreeName: null
      },
      educationOptions: [{ // 学历选择框
        value: '1',
        label: '大专'
      }, {
        value: '2',
        label: '本科'
      }, {
        value: '3',
        label: '研究生'
      }],
      formMsg: {
        empName: null,
        sex: null,
        age: null,
        deptName: null,
        empDegreeName: null
      },
      // 表单验证
      rules: {
        empName: [
          { required: true, message: '请输入', trigger: 'blur' },
          { min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'blur' }
        ],
        sex: [
          { required: true, message: '请选择', trigger: 'blur' }
        ],
        age: [
          { required: true, message: '请输入', trigger: 'blur' },
        ],
        deptName: [
          { required: true, message: '请选择', trigger: 'blur' }
        ],
        empDegreeName: [
          { required: true, message: '请选择', trigger: 'blur' }
        ]
      },
      downloadLoading: false,
      dialogTitle: '新增信息',
      // 添加编辑弹框控制
      dialogVisible: false
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData(query) {
      this.listLoading = true
      getList({ ...query, current: this.currentPage, size: this.size }).then(response => {
        this.list = response.data.records
        this.total = response.data.total
        this.listLoading = false
      })
    },
    handleSizeChange(val) {
      this.size = val
      this.fetchData()
    },
    handleCurrentChange(val) {
      this.currentPage = val
      this.fetchData()
    },
    // 获取性别
    getSex(row, column) {
      if (row.sex === 0) {
        return '男'
      } else if (row.sex === 1) {
        return '女'
      } else {
        return row.sex
      }
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
          this.formMsg = {
            empName: null,
            sex: null,
            age: null,
            deptName: null,
            empDegreeName: null
          }
        })
        .catch(_ => {})
    },
    cancel(formName) {
      this.dialogVisible = false
      this.$refs[formName].resetFields()
      this.formMsg = {
        empName: null,
        sex: null,
        age: null,
        deptName: null,
        empDegreeName: null
      }
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.dialogVisible = false
          if (this.dialogTitle === '新增信息') {
            addMsg(this.formMsg).then((res) => {
              if (res.code === 200) {
                this.fetchData()
                this.$message({
                  type: 'success',
                  message: '新增成功'
                })
              } else {
                this.$message({
                  type: 'error',
                  message: res.msg
                })
              }
            })
          } else if (this.dialogTitle === '编辑信息') {
            editMsg(this.formMsg).then((res) => {
              if (res.code === 200) {
                this.fetchData()
                this.$message({
                  type: 'success',
                  message: '编辑成功'
                })
              } else {
                this.$message({
                  type: 'error',
                  message: res.msg
                })
              }
            })
          }
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    // 导出
    handleDownload() {
      this.downloadLoading = true
      import('@/vendor/Export2Excel').then(excel => {
        const tHeader = ['序号', '姓名', '性别', '年龄', '部门', '学历']
        const filterVal = ['empId', 'empName', 'sex', 'age', 'deptName', 'empDegreeName']
        const data = this.formatJson(filterVal)
        excel.export_json_to_excel({
          header: tHeader,
          data,
          filename: '职工信息'
        })
        this.downloadLoading = false
      })
    },
    formatJson(filterVal) {
      return this.list.map(v => filterVal.map(j => {
        return v[j]
      }))
    },
    // 搜索事件
    async search() {
      this.fetchData(this.searchInfo)
      this.searchInfo = {
        empName: null,
        deptName: null,
        empDegreeName: null
      }
    },
    // 增
    addEmp() {
      this.dialogTitle = '新增信息'
      this.dialogVisible = true
    },
    // 删
    deleteRow(row) {
      deleteEmp({ id: row.empId }).then(() => this.fetchData())
    },
    // 改
    editEmp(row) {
      this.dialogTitle = '编辑信息'
      this.formMsg = { ...row }
      this.dialogVisible = true
    }
  }
}
</script>

<style scoped>
.header {
  display: flex;
}
</style>
