/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import setLang from '../lang'
import Config from '../../config'

const lang = {}

lang[Config.localePrefix] = {
  locale: 'zh-CN',
  select: {
    placeholder: '请选择',
    noMatch: '无匹配数据',
    loading: '加载中'
  },
  cascader: {
    noMatch: '无匹配数据',
    loading: '加载中',
    placeholder: '请选择'
  },
  table: {
    noDataText: '暂无数据',
    noFilteredDataText: '暂无筛选结果',
    confirmFilter: '筛选',
    resetFilter: '重置',
    clearFilter: '全部'
  },
  datepicker: {
    now: '此刻',
    today: '今天',
    cancel: '取消',
    clear: '清空',
    confirm: '确定',
    selectDate: '选择日期',
    selectTime: '选择时间',
    startDate: '开始日期',
    startTime: '开始时间',
    endDate: '结束日期',
    endTime: '结束时间',
    prevYear: '前一年',
    nextYear: '后一年',
    prevMonth: '上个月',
    nextMonth: '下个月',
    year: '年',
    month1: '1 月',
    month2: '2 月',
    month3: '3 月',
    month4: '4 月',
    month5: '5 月',
    month6: '6 月',
    month7: '7 月',
    month8: '8 月',
    month9: '9 月',
    month10: '10 月',
    month11: '11 月',
    month12: '12 月',
    // week: '周次',
    weeks: {
      sun: '日',
      mon: '一',
      tue: '二',
      wed: '三',
      thu: '四',
      fri: '五',
      sat: '六'
    },
    months: {
      jan: '一月',
      feb: '二月',
      mar: '三月',
      apr: '四月',
      may: '五月',
      jun: '六月',
      jul: '七月',
      aug: '八月',
      sep: '九月',
      oct: '十月',
      nov: '十一月',
      dec: '十二月'
    }
  },
  transfer: {
    titles: {
      source: '源列表',
      target: '目的列表'
    },
    filterPlaceholder: '请输入搜索内容',
    notFoundText: '列表为空'
  },
  dialog: {
    info: '信息',
    success: '成功',
    warning: '警告',
    error: '错误',
    okText: '确定',
    cancelText: '取消'
  },
  popover: {
    okText: '确定',
    cancelText: '取消'
  },
  pagination: {
    prevText: '上一页',
    nextText: '下一页',
    total: '共',
    item: '条',
    items: '条',
    pageSize: '条/页',
    goto: '前往',
    pageText: '页',
    prev5Text: '向前5页',
    next5Text: '向后5页'
  },
  rate: {
    star: '星',
    stars: '星'
  },
  tree: {
    emptyText: '暂无数据'
  },
  loading: {
    loadingText: '加载中...'
  },
  upload: {
    deleteTip: '按 delete 键可删除',
    delete: '删除',
    preview: '查看图片',
    continue: '继续上传'
  },
  charts: {
    noDataText: '暂无数据',
    otherText: '其他'
  }
}

setLang(lang)

export default lang
