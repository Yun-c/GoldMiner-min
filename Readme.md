Java小游戏开发合集
mac : BUTTON1 触摸板点一次 BUTTON2 触摸板点两次
1.黄金矿工
    1.1 基础场景创建
        1.1.1 窗口
        1.1.2 背景
        1.1.3 矿工
        1.1.4 线
        1.1.5 金子
            坐标:x y 
            体积:width height
        1.1.6 钩子
            绑定到线的末端
        1.1.7 基础场景问题
            窗体组件闪动问题
            双缓存技术:先创建一个画布,把物体绘制到画布上，然后在把画布绘制上去
    1.2 抓取
        1.2.1 抓取判定
            线的end_x > 物体的end_x
            线的end_x < 物体的end_x+物体的width
            线的end_y > 物体的end_y
            线的end_y < 物体的end_y+物体的height
        1.2.2 抓取返回
            BUG：循环移动移动了所有的金块，需要给物体添加标志位来判断是否需要移动
    1.3 添加积分板
        记录当前得分
    1.4 添加炸弹爆破技能
        1.4.1  使用 检测 右键
        1.4.2  检测线的状态，只能在抓取的时候使用
        1.4.3  检测物体的类型,只能对石头使用
        1.4.4  使用之后,移除石头
        1.4.5  移除石头之后，快速回收线
        1.4.6  石块炸毁加分 金块炸毁扣分
    1.5 添加关卡
        1.5.1 关卡数
        1.5.2 关卡目标积分
        1.5.3 难度变更
            随着难度的增加,金块数量减少,石块数量增多，目标分数增速20
            金块+石块的总数=50
        1.5.4 下一关刷新窗口
    1.6 游戏的状态
        1.6.1 准备中
        1.6.2 进行中
        1.6.3 成功
        1.6.4 失败
    1.7 添加计时
    1.8
     
    