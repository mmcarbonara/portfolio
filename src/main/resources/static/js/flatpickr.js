let maxDate = new Date();
maxDate = maxDate.setMonth(maxDate.getMonth() + 3);  

//予約日程の設定
flatpickr('#reservedDate', {
	mode: "range",
    locale: 'ja',
    minDate: 'today',　//今日の日付のみ選択可能
    maxdate: maxDate
});

  // 予約時間の設定 
  flatpickr('#reservedTime', {
    enableTime: true,        // 時間の選択を有効にする
    noCalendar: true,        // カレンダーは不要 (時間のみの選択)
    time_24hr: true,         // 24時間形式で時間を表示
    dateFormat: "H:i",       // 時間フォーマットを「時:分」に設定
    minDate: 'today',        // 今日以降の時間のみ選択可能
    locale: 'ja'          
  });