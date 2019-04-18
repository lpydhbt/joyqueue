webpackJsonp([38],{PfeY:function(t,e){},W9DL:function(t,e,r){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=r("1a0f"),o=r("M3bc"),i=r("X2Oc"),s=r("lcoF"),n=r("H/ue"),c={name:"topic-form",mixins:[s.a],components:{addBroker:n.default},props:{type:0,data:{type:Object,default:function(){return{code:"",name:"",type:0,namespace:{id:"0",code:""},partitions:5,brokerGroup:{id:-1,code:"",name:""},electType:0,description:"",brokers:[]}}}},data:function(){var t=this;return{current:0,formData:this.data,partitionsDisabled:!1,namespaceList:[],brokerGroupList:[],brokerList:[],urls:{findAllNamespace:"/namespace/findAll",findAllBrokerGroup:"/brokerGroup/findAll",searchBroker:"/broker/search",add:"/topic/addWithBrokerGroup"},rules:{rule1:{code:[{required:!0,message:"请输入topic英文名",trigger:"change"},{pattern:/^[a-zA-Z/]+[a-zA-Z0-9/_-]{1,120}[a-zA-Z0-9/]+$/,message:"英文名格式不匹配",trigger:"change"}],name:Object(i.h)(),partitions:[{type:"number",required:!0,message:"请输入队列数量",trigger:"change"}],brokerGroup:[{required:!0,message:"请选择一个分组",trigger:"change"}],description:[{required:!0,message:"请输入申请描述",trigger:"change"}]},rule2:{brokers:[{type:"array",required:!0,message:"请至少选择一个Broker",trigger:"change"},{validator:function(e,r,a){void 0!==t.formData.topic.partitions&&void 0!==t.formData.topic.brokers&&t.formData.topic.brokers.length>t.formData.topic.partitions?a(new Error("勾选的broker数量不能大于队列数量")):a()},trigger:"blur"}]}},error:{code:""}}},methods:{prev:function(){this.current=this.current-1},next:function(){var t=this;this.$refs["form"+(this.current+1)].validate(function(e){e?t.current=t.current+1:t.$Message.error("验证不通过，请重新填写！")})},choosedBroker:function(t){this.formData.brokers=t},handlerTypeChange:function(t){2===t?(this.partitionsDisabled=!0,this.formData.partitions=1):(this.partitionsDisabled=!1,this.formData.partitions=5)},handlerBrokerGroupChange:function(t){this.$refs.brokers.getListByGroup(t)},getNamespaces:function(){var t=this;a.a.get(this.urls.findAllNamespace).then(function(e){t.namespaceList=e.data||[]})},getBrokerGroups:function(){var t=this;a.a.get(this.urls.findAllBrokerGroup).then(function(e){(void 0===e.data||e.data.length<1)&&(t.brokerGroupList=[{id:0,code:"",name:"全部"}]),t.brokerGroupList=[];t.brokerGroupList.push({id:0,code:"",name:"全部"}),(e.data||[]).forEach(function(e){t.brokerGroupList.push(e)})})},beforeConfirm:function(){return Object(o.e)(this.formData||{})}},computed:{},mounted:function(){this.getNamespaces(),this.getBrokerGroups()}},p={render:function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("d-steps",{attrs:{current:t.current}},[r("d-step",{attrs:{title:"步骤1",description:"主题信息"}}),t._v(" "),r("d-step",{attrs:{title:"步骤2",description:"Broker列表"}})],1),t._v(" "),r("div",{staticClass:"steps-content",staticStyle:{"margin-top":"15px",border:"1px solid #e9e9e9","border-radius":"6px","min-height":"200px","text-align":"left",padding:"20px 30px 40px 50px"}},[r("div",{directives:[{name:"show",rawName:"v-show",value:0===t.current,expression:"current===0"}],staticClass:"step1"},[r("div",{staticClass:"stepForm1"},[r("d-form",{ref:"form1",staticStyle:{height:"350px","overflow-y":"auto",width:"100%"},attrs:{model:t.formData,rules:t.rules.rule1,"label-width":"110px"}},[r("d-form-item",{attrs:{label:"主题英文名：",error:t.error.code,prop:"code"}},[r("d-input",{staticStyle:{width:"70%"},attrs:{placeholder:"仅支持英文字母大小写、数字、-、_和/"},model:{value:t.formData.code,callback:function(e){t.$set(t.formData,"code",e)},expression:"formData.code"}})],1),t._v(" "),r("d-form-item",{attrs:{label:"主题类型：",prop:"type"}},[r("d-select",{staticStyle:{width:"70%"},attrs:{value:0},on:{"on-change":t.handlerTypeChange},model:{value:t.formData.type,callback:function(e){t.$set(t.formData,"type",e)},expression:"formData.type"}},[r("d-option",{attrs:{value:0}},[t._v("普通主题")]),t._v(" "),r("d-option",{attrs:{value:1}},[t._v("广播主题")]),t._v(" "),r("d-option",{attrs:{value:2}},[t._v("顺序主题")])],1)],1),t._v(" "),r("d-form-item",{attrs:{label:"队列数量：",prop:"partitions"}},[r("d-input",{staticStyle:{width:"70%"},attrs:{disabled:t.partitionsDisabled},model:{value:t.formData.partitions,callback:function(e){t.$set(t.formData,"partitions",t._n(e))},expression:"formData.partitions"}})],1),t._v(" "),r("d-form-item",{attrs:{label:"选举类型：",prop:"electType"}},[r("d-select",{staticStyle:{width:"70%"},model:{value:t.formData.electType,callback:function(e){t.$set(t.formData,"electType",t._n(e))},expression:"formData.electType"}},[r("d-option",{attrs:{value:0}},[t._v("Raft")]),t._v(" "),r("d-option",{attrs:{value:1}},[t._v("Fix")])],1)],1),t._v(" "),r("d-form-item",{attrs:{label:"分组：",prop:"brokerGroup"}},[r("d-select",{staticStyle:{width:"70%"},on:{"on-change":t.handlerBrokerGroupChange},model:{value:t.formData.brokerGroup.id,callback:function(e){t.$set(t.formData.brokerGroup,"id",e)},expression:"formData.brokerGroup.id"}},t._l(t.brokerGroupList,function(e){return r("d-option",{key:e.id,attrs:{value:e.id}},[r("span",[t._v(t._s(e.name))]),t._v(" "),r("span",{staticStyle:{float:"right",color:"#ccc"}},[t._v(t._s(e.code))])])}),1)],1),t._v(" "),r("d-form-item",{attrs:{label:"申请描述：",prop:"description"}},[r("d-input",{staticStyle:{width:"70%"},attrs:{type:"textarea",rows:"2",placeholder:"请输入申请描述，例如用途等"},model:{value:t.formData.description,callback:function(e){t.$set(t.formData,"description",e)},expression:"formData.description"}})],1)],1)],1),t._v(" "),r("div",{staticClass:"step-actions",staticStyle:{"text-align":"center"}},[r("d-button",{attrs:{type:"primary"},on:{click:t.next}},[t._v("下一步")])],1)]),t._v(" "),r("div",{directives:[{name:"show",rawName:"v-show",value:1===t.current,expression:"current===1"}],staticClass:"step2"},[r("div",{staticClass:"stepForm2"},[r("d-form",{ref:"form",staticStyle:{"overflow-y":"auto",height:"350px"},attrs:{model:t.formData,rules:t.rules.rule2,"label-width":"100px"}},[r("add-broker",{ref:"brokers",attrs:{model:t.formData.brokers,data:t.formData},on:{"on-choosed-broker":t.choosedBroker}})],1)],1),t._v(" "),r("div",{staticClass:"step-actions",staticStyle:{"text-align":"center"}},[r("d-button",{attrs:{type:"primary"},on:{click:t.prev}},[t._v("上一步")]),t._v(" "),r("d-button",{attrs:{type:"primary"},on:{click:function(e){return t.confirm()}}},[t._v("确定")])],1)])])],1)},staticRenderFns:[]};var d=r("VU/8")(c,p,!1,function(t){r("PfeY")},"data-v-0949d627",null);e.default=d.exports}});
//# sourceMappingURL=38.ad6b8c1f0b4a24b904f2.js.map