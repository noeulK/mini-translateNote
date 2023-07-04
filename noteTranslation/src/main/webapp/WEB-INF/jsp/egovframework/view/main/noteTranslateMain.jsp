<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/header.jsp" %>

<div class="page-wrapper page-wrapping" >
<div class="page-body wrapping-page">

	<div class="containder-xl" >
		<div class="row row-cards dash-card-margin">
			<div class="col-md-6 col-lg-6" >
                <div class="card card-inactive body-top-navibar nav-card ">
                  <div class="card-body row" style="padding-left: 10%;">
                    <div class="col-6">
                    	<span class="text-center" id="today">2023 . 6 . 16 금요일</span>
                    </div>
                  </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-6">
                <div class="card body-top-navibar nav-card" style="background-color: rgb(256,182,36);">
                  <div class="card-body row" style="padding-left:10%;">
                    <div class="col-3 "><!-- Download SVG icon from http://tabler-icons.io/i/pencil -->
						<span style="cursor:pointer;" onclick="writeNote()"><svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
						<path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M4 20h4l10.5 -10.5a1.5 1.5 0 0 0 -4 -4l-10.5 10.5v4"></path>
						<line x1="13.5" y1="6.5" x2="17.5" y2="10.5"></line></svg>
						노트 쓰기 </span>
					</div>
					<div class="col-3">
					<!-- Download SVG icon from http://tabler-icons.io/i/clipboard-check -->
						<span style="cursor:pointer;"><svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
						<path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2"></path>
						<rect x="9" y="3" width="6" height="4" rx="2"></rect><path d="M9 14l2 2l4 -4"></path></svg>
						단어 시험</span>
					</div>
					<div class="col-3">
						<!-- Download SVG icon from http://tabler-icons.io/i/user -->
						<span style="cursor:pointer;"><svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
						<path stroke="none" d="M0 0h24v24H0z" fill="none"></path><circle cx="12" cy="7" r="4"></circle>
						<path d="M6 21v-2a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v2"></path></svg> 
						내정보</span> 
					</div>
					<div class="col-3 ">
						<!-- Download SVG icon from http://tabler-icons.io/i/logout -->
						<span style="cursor:pointer;"><svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
						<path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
						<path d="M14 8v-2a2 2 0 0 0 -2 -2h-7a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h7a2 2 0 0 0 2 -2v-2"></path>
						<path d="M7 12h14l-3 -3m0 6l3 -3"></path></svg> 
						로그아웃 </span>
					</div>
                  </div>
                </div>
            </div>
		</div>
	</div>
	
	<div class="contatiner-xl body-card-button-tools dash-card-margin">
		<div class="col-md-12 col-lg-12">
                <div class="card">
                  <div class="card-header">
                    <h3 class="card-title"><!-- Download SVG icon from http://tabler-icons.io/i/letter-case -->
						<svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
						<path stroke="none" d="M0 0h24v24H0z" fill="none"></path><circle cx="17.5" cy="15.5" r="3.5"></circle>
						<path d="M3 19v-10.5a3.5 3.5 0 0 1 7 0v10.5"></path><path d="M3 13h7"></path><path d="M21 12v7"></path>
						</svg> 단어장 </h3>
                  </div>
                  <div class="table-responsive">
                    <table class="table card-table table-vcenter">
                      <tbody>
                      
                      	
                      
                      <tr>
                        <td class="w-1 pe-0">
                          <i class="fa-regular fa-circle fa-2xs"></i>
                        </td>
                        <td class="w-100">
                          <a href="javascript:void(0)" onclick="openVoca('42','Drivers notch up over 600 laps in Pirelli’s 2024 tyre test as Mick Schumacher makes Mercedes debut' )" class="text-reset">
                          
	                          
	                          
	                          	Drivers notch up over 600 laps in Pirelli’s 2024 tyre test as Mick Schumacher makes Mercedes debut
	                          
	                          	
                          </a>
                        </td>
                        <td class="text-nowrap">
                          <a href="#" class="text-muted">
                            <!-- Download SVG icon from http://tabler-icons.io/i/check -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M5 12l5 5l10 -10"></path></svg>
                            2/4
                          </a>
                        </td>
                        <td class="text-nowrap text-muted">
                          <!-- Download SVG icon from http://tabler-icons.io/i/calendar -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><rect x="4" y="5" width="16" height="16" rx="2"></rect><line x1="16" y1="3" x2="16" y2="7"></line><line x1="8" y1="3" x2="8" y2="7"></line><line x1="4" y1="11" x2="20" y2="11"></line><line x1="11" y1="15" x2="12" y2="15"></line><line x1="12" y1="15" x2="12" y2="18"></line></svg>
                          2023년 6월 8일 목요일
                        </td>
                      </tr>
                      
                      <tr>
                        <td class="w-1 pe-0">
                          <i class="fa-regular fa-circle fa-2xs"></i>
                        </td>
                        <td class="w-100">
                          <a href="javascript:void(0)" onclick="openVoca('43','Lewis Hamilton says racist abuse suffered by Vinícius Jr. evokes painful memories' )" class="text-reset">
                          
	                          
	                          
	                          	Lewis Hamilton says racist abuse suffered by Vinícius Jr. evokes painful memories
	                          
	                          	
                          </a>
                        </td>
                        <td class="text-nowrap">
                          <a href="#" class="text-muted">
                            <!-- Download SVG icon from http://tabler-icons.io/i/check -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M5 12l5 5l10 -10"></path></svg>
                            2/4
                          </a>
                        </td>
                        <td class="text-nowrap text-muted">
                          <!-- Download SVG icon from http://tabler-icons.io/i/calendar -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><rect x="4" y="5" width="16" height="16" rx="2"></rect><line x1="16" y1="3" x2="16" y2="7"></line><line x1="8" y1="3" x2="8" y2="7"></line><line x1="4" y1="11" x2="20" y2="11"></line><line x1="11" y1="15" x2="12" y2="15"></line><line x1="12" y1="15" x2="12" y2="18"></line></svg>
                          2023년 6월 8일 목요일
                        </td>
                      </tr>
                      
                      
                    </tbody></table>
                  </div>
                </div>
              </div>
	 
    </div>

		<div class="containder-xl">
			<div class="expandable">
				<div class="row">
				
				
				
					<div class="col-4">
						<div class="card">
							<div class="card-body">
								<h3 class="card-title">
								
									
									
										toto&amp;apos;s car
									
								
								</h3>
								<div class="card-subtitle">2023년 6월 8일 목요일</div>
								<p>
								
									
										‘We’re going to get there’ – Wolff convinced Mercedes are now on the right path back to winning ways Mercedes brought a host of new upgrades for their car to Monaco – and though it’s far from the ideal track to assess their effectiveness, Toto Wolff is convinced his team are now moving in the right....
									
									
								
								</p>
							</div>
						</div>
					</div>
				
					<div class="col-4">
						<div class="card">
							<div class="card-body">
								<h3 class="card-title">
								
									
										Drivers notch up over 600 laps in Pirelli’s 2024 tyre test as Mick Sc....
									
									
								
								</h3>
								<div class="card-subtitle">2023년 6월 8일 목요일</div>
								<p>
								
									
										Ferrari and Mercedes’ drivers have notched up over 600 laps between them over the course of two days of lapping the Circuit de Barcelona-Catalunya – host of last weekend’s Spanish Grand Prix – as Pirelli tested a selection of proposed tyre compounds for the 2024 season. Ferrari’s Charles Leclerc an....
									
									
								
								</p>
							</div>
						</div>
					</div>
				
					<div class="col-4">
						<div class="card">
							<div class="card-body">
								<h3 class="card-title">
								
									
										Lewis Hamilton says racist abuse suffered by Vinícius Jr. evokes pain....
									
									
								
								</h3>
								<div class="card-subtitle">2023년 6월 8일 목요일</div>
								<p>
								
									
										Seven-time Formula One world champion Lewis Hamilton said Thursday that the racism suffered by Real Madrid forward Vinícius Jr. in Spain’s La Liga reminds him of his own career experiences of discrimination. “It’s devastating to think that in 2023 we’re still seeing these things and hearing these t....
									
									
								
								</p>
							</div>
						</div>
					</div>
				
				</div>
			</div>
		</div>



		




	</div>
</div>

<%@ include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/footer.jsp" %>